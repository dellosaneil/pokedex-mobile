package com.dellosaneil.pokedex_mobile.network.pagination

import com.apollographql.apollo3.api.ApolloResponse

interface PokedexPagination {
    suspend fun initialLoad(
        callback: suspend (Int) -> ApolloResponse<*>,
        limit: Int,
    ): ApolloResponse<*>

    suspend fun loadMore(callback: suspend (Int, Int) -> ApolloResponse<*>): ApolloResponse<*>
}
