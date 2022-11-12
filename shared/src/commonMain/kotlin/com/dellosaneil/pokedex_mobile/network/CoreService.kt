package com.dellosaneil.pokedex_mobile.network

import com.apollographql.apollo3.ApolloClient

interface CoreService {
    operator fun invoke() : ApolloClient
}
