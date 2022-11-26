package com.dellosaneil.pokedex_mobile.model.pokemondetail

import com.dellosaneil.pokedex_mobile.model.common.PokemonType

data class PokemonDetail(
    val name: String,
    val image: String,
    val stat: List<Int>,
    val pokemonType: List<PokemonType>,
    val aboutPokemon: AboutPokemon,
) {
    companion object {
        fun compose() : PokemonDetail {
            return PokemonDetail(
                name = "Bulbasaur",
                pokemonType = listOf(PokemonType.GRASS),
                image = "https://media.tenor.com/6nHb-yHC2pkAAAAi/bulbasaur.gif",
                stat = listOf(1,2,3),
                aboutPokemon = AboutPokemon.compose(),
            )
        }
    }
}
