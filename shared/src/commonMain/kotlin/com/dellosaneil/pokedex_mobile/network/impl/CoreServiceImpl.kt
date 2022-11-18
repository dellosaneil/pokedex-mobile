package com.dellosaneil.pokedex_mobile.network.impl

import com.apollographql.apollo3.ApolloClient
import com.dellosaneil.pokedex_mobile.network.CoreService

class CoreServiceImpl : CoreService {
    companion object {
        private const val URL = "https://beta.pokeapi.co/graphql/v1beta"
    }


    override fun invoke(): ApolloClient {
        return ApolloClient.Builder().serverUrl(URL).build()
    }
}
