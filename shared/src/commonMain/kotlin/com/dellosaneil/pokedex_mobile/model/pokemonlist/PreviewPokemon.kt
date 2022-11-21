package com.dellosaneil.pokedex_mobile.model.pokemonlist

import com.dellosaneil.pokedex_mobile.model.common.Type

data class PreviewPokemon(
    val id : Int,
    val name: String,
    val type: List<Type>,
    val image: String,
) {
    companion object {
        fun compose() : PreviewPokemon {
            return PreviewPokemon(
                id = 1,
                name = "Bulbasaur",
                type = listOf(Type.GRASS),
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            )
        }
    }
}
