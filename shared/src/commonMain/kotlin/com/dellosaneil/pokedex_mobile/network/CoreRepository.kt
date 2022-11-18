package com.dellosaneil.pokedex_mobile.network

import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon

interface CoreRepository {
    suspend fun fetchPokemonList() : List<PreviewPokemon>
}
