package com.dellosaneil.pokedex_mobile.network

interface FetchPokemonList {
    suspend operator fun invoke()
}
