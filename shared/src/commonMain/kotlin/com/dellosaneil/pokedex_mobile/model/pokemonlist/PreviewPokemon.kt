package com.dellosaneil.pokedex_mobile.model.pokemonlist

import com.dellosaneil.pokedex_mobile.model.common.Type

data class PreviewPokemon(
    val id : Int,
    val name: String,
    val type: List<Type>,
    val image: String,
)
