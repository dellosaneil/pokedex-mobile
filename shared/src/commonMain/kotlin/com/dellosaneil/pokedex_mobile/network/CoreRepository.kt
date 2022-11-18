package com.dellosaneil.pokedex_mobile.network

interface CoreRepository {
    suspend fun fetchPokemonList()
}
