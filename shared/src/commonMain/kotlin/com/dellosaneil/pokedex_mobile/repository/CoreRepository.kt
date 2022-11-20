package com.dellosaneil.pokedex_mobile.repository

import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon

interface CoreRepository {
    suspend fun fetchPokemonList(isInitialLoad: Boolean): List<PreviewPokemon>
}
