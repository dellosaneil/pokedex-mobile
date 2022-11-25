package com.dellosaneil.pokedex_mobile.model

import com.dellosaneil.pokedex_mobile.model.common.PokemonType

data class PokemonDetail(
    val name: String,
    val image: String,
    val weight: Int,
    val height: Int,
    val stat: List<Int>,
    val pokemonType: List<PokemonType>,
) {
    companion object {
        fun compose() : PokemonDetail {
            return PokemonDetail(
                name = "Bulbasaur",
                pokemonType = listOf(PokemonType.GRASS),
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                stat = listOf(1,2,3),
                height = 10,
                weight = 50,
            )
        }
    }
}
