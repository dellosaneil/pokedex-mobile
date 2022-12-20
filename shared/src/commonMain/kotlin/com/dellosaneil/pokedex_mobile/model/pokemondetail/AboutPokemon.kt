package com.dellosaneil.pokedex_mobile.model.pokemondetail

data class AboutPokemon(
    val height: Float,
    val weight: Float,
    val abilities: String,
    val gender: Pair<Float, Float>,
) {
    companion object {
        fun compose(): AboutPokemon {
            return AboutPokemon(
                height = 70f,
                weight = 15f,
                abilities = "Overgrow, Chlorophyl",
                gender = 87.5f to 12.5f,
            )
        }
    }
}
