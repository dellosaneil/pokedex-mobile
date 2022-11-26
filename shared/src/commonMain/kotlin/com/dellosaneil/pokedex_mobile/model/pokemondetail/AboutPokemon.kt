package com.dellosaneil.pokedex_mobile.model.pokemondetail

data class AboutPokemon(
    val species: String,
    val height: Float,
    val weight: Float,
    val abilities: String,
    val gender: Pair<Float, Float>,
    val eggGroups: String,
    val eggCycle: String,
) {
    companion object {
        fun compose(): AboutPokemon {
            return AboutPokemon(
                species = "Seed",
                height = 0.70f,
                weight = 15.2f,
                abilities = "Overgrow, Chlorophyl",
                gender = 87.5f to 12.5f,
                eggGroups = "Monster",
                eggCycle = "Grass",
            )
        }
    }
}
