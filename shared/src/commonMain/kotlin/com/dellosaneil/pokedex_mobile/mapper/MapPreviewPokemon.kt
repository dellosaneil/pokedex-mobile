package com.dellosaneil.pokedex_mobile.mapper

import com.dellosaneil.PokemonListQuery
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon

interface MapPreviewPokemon {
    operator fun invoke(`data`: PokemonListQuery.Data?) : List<PreviewPokemon>
}
