package com.dellosaneil.pokedex_mobile.repository.impl

import com.apollographql.apollo3.api.Optional
import com.dellosaneil.PokemonDetailQuery
import com.dellosaneil.PokemonListQuery
import com.dellosaneil.pokedex_mobile.mapper.MapPokemonDetail
import com.dellosaneil.pokedex_mobile.mapper.MapPreviewPokemon
import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import com.dellosaneil.pokedex_mobile.network.CoreService
import com.dellosaneil.pokedex_mobile.network.pagination.PokedexPagination
import com.dellosaneil.pokedex_mobile.repository.CoreRepository

class CoreRepositoryImpl(
    private val coreService: CoreService,
    private val mapPreviewPokemon: MapPreviewPokemon,
    private val pokedexPagination: PokedexPagination,
    private val mapPokemonDetail: MapPokemonDetail,
) : CoreRepository {

    companion object {
        private const val POKEMON_LIST_LIMIT = 20
    }

    override suspend fun fetchPokemonList(isInitialLoad: Boolean): List<PreviewPokemon> {
        val response = if (isInitialLoad) {
            pokedexPagination.initialLoad(
                callback = { limit ->
                    coreService().query(query = PokemonListQuery(limit = Optional.Present(value = limit),
                        offset = Optional.Present(value = 0))).execute()
                },
                limit = POKEMON_LIST_LIMIT,
            )
        } else {
            pokedexPagination.loadMore(callback = { limit, offset ->
                coreService().query(query = PokemonListQuery(limit = Optional.Present(limit),
                    offset = Optional.Present(offset))).execute()
            })
        }
        return mapPreviewPokemon(data = response.data as PokemonListQuery.Data?)
    }

    override suspend fun fetchPokemonDetail(id: Int): PokemonDetail {
        val response =
            coreService().query(query = PokemonDetailQuery(id = Optional.Present(value = id))).execute()
        return mapPokemonDetail(data = response.data)
    }
}
