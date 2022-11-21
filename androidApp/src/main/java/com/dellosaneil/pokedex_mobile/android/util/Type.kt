package com.dellosaneil.pokedex_mobile.android.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.model.common.Type

@Composable
fun Type.getColor() : Color {
    return when(this) {
        Type.NORMAL -> getComposeColors().typeColors.normal
        Type.FIGHTING -> getComposeColors().typeColors.fighting
        Type.FLYING -> getComposeColors().typeColors.flying
        Type.POISON -> getComposeColors().typeColors.poison
        Type.GROUND -> getComposeColors().typeColors.ground
        Type.ROCK -> getComposeColors().typeColors.rock
        Type.BUG -> getComposeColors().typeColors.bug
        Type.GHOST -> getComposeColors().typeColors.ghost
        Type.STEEL -> getComposeColors().typeColors.steel
        Type.FIRE -> getComposeColors().typeColors.fire
        Type.WATER -> getComposeColors().typeColors.water
        Type.GRASS -> getComposeColors().typeColors.grass
        Type.ELECTRIC -> getComposeColors().typeColors.electric
        Type.PSYCHIC -> getComposeColors().typeColors.psychic
        Type.ICE -> getComposeColors().typeColors.ice
        Type.DRAGON -> getComposeColors().typeColors.dragon
        Type.DARK -> getComposeColors().typeColors.dark
        Type.FAIRY -> getComposeColors().typeColors.fairy
        Type.SHADOW -> getComposeColors().typeColors.dark
        Type.UNKNOWN -> getComposeColors().typeColors.normal
    }
}
