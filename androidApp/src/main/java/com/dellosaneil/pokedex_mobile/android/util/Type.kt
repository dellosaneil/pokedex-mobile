package com.dellosaneil.pokedex_mobile.android.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.model.common.PokemonType

@Composable
fun PokemonType.getColor() : Color {
    return when(this) {
        PokemonType.NORMAL -> getComposeColors().typeColors.normal
        PokemonType.FIGHTING -> getComposeColors().typeColors.fighting
        PokemonType.FLYING -> getComposeColors().typeColors.flying
        PokemonType.POISON -> getComposeColors().typeColors.poison
        PokemonType.GROUND -> getComposeColors().typeColors.ground
        PokemonType.ROCK -> getComposeColors().typeColors.rock
        PokemonType.BUG -> getComposeColors().typeColors.bug
        PokemonType.GHOST -> getComposeColors().typeColors.ghost
        PokemonType.STEEL -> getComposeColors().typeColors.steel
        PokemonType.FIRE -> getComposeColors().typeColors.fire
        PokemonType.WATER -> getComposeColors().typeColors.water
        PokemonType.GRASS -> getComposeColors().typeColors.grass
        PokemonType.ELECTRIC -> getComposeColors().typeColors.electric
        PokemonType.PSYCHIC -> getComposeColors().typeColors.psychic
        PokemonType.ICE -> getComposeColors().typeColors.ice
        PokemonType.DRAGON -> getComposeColors().typeColors.dragon
        PokemonType.DARK -> getComposeColors().typeColors.dark
        PokemonType.FAIRY -> getComposeColors().typeColors.fairy
        PokemonType.SHADOW -> getComposeColors().typeColors.dark
        PokemonType.UNKNOWN -> getComposeColors().typeColors.normal
    }
}
