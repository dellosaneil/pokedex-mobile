package com.dellosaneil.pokedex_mobile.network.pagination.impl

import com.apollographql.apollo3.api.ApolloResponse
import com.dellosaneil.PokemonListQuery
import com.dellosaneil.pokedex_mobile.network.pagination.PokedexPagination

class PokedexPaginationImpl : PokedexPagination {

    private var limit = -1
    private var page = -1

    private var isEndOfPage = false
    private var isLoading = false


    override suspend fun initialLoad(
        callback: suspend (Int) -> ApolloResponse<*>,
        limit: Int,
    ): ApolloResponse<*> {
        this.limit = limit
        this.page = 0
        isEndOfPage = false
        isLoading = true
        val response = callback(limit)
        isLoading = false
        isEndOfPage(response = response)
        return response
    }

    override suspend fun loadMore(callback: suspend (Int, Int) -> ApolloResponse<*>): ApolloResponse<*> {
        page++
        val offset = page * limit
        val response = try {
            isLoading = true
            callback(limit, offset)
        } catch (e: Exception) {
            throw Exception(e)
        }
        isLoading = false
        isEndOfPage(response = response)
        return response
    }

    private fun isEndOfPage(response: ApolloResponse<*>) {
        when (val responseData = response.data) {
            is PokemonListQuery.Data -> {
                isEndOfPage = responseData.pokemon_v2_pokemon.size != limit
            }
            else -> {
                throw Exception("handle Pagination isEndOfPage")
            }
        }
    }

}
