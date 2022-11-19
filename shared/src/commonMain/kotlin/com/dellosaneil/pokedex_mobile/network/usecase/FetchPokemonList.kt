package com.dellosaneil.pokedex_mobile.network.usecase

import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon

interface FetchPokemonList {
    suspend operator fun invoke() : List<PreviewPokemon>
}
