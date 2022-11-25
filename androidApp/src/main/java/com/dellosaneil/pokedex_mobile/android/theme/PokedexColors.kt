package com.dellosaneil.pokedex_mobile.android.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.dellosaneil.pokedex_mobile.android.util.toColor

class TypeColors(
    val normal : Color = PokedexColorPalette.TypeColors.Normal.toColor(),
    val fire : Color = PokedexColorPalette.TypeColors.Fire.toColor(),
    val water : Color = PokedexColorPalette.TypeColors.Water.toColor(),
    val electric: Color = PokedexColorPalette.TypeColors.Electric.toColor(),
    val grass : Color = PokedexColorPalette.TypeColors.Grass.toColor(),
    val ice: Color = PokedexColorPalette.TypeColors.Ice.toColor(),
    val fighting: Color = PokedexColorPalette.TypeColors.Fighting.toColor(),
    val poison : Color = PokedexColorPalette.TypeColors.Poison.toColor(),
    val flying: Color = PokedexColorPalette.TypeColors.Flying.toColor(),
    val psychic: Color = PokedexColorPalette.TypeColors.Psychic.toColor(),
    val bug: Color = PokedexColorPalette.TypeColors.Bug.toColor(),
    val rock :Color = PokedexColorPalette.TypeColors.Rock.toColor(),
    val ghost: Color = PokedexColorPalette.TypeColors.Ghost.toColor(),
    val dragon: Color = PokedexColorPalette.TypeColors.Dragon.toColor(),
    val dark: Color = PokedexColorPalette.TypeColors.Dark.toColor(),
    val steel: Color = PokedexColorPalette.TypeColors.Steel.toColor(),
    val fairy: Color = PokedexColorPalette.TypeColors.Fairy.toColor(),
    val ground: Color = PokedexColorPalette.TypeColors.Ground.toColor(),
)

class CommonColors(
    val white : Color = PokedexColorPalette.CommonColors.White.toColor(),
    val black : Color = PokedexColorPalette.CommonColors.Black.toColor(),
    val lightGray1 : Color = PokedexColorPalette.CommonColors.LightGray1.toColor(),
    val lightGray2: Color = PokedexColorPalette.CommonColors.LightGray2.toColor(),
    val lightBlue1: Color = PokedexColorPalette.CommonColors.LightBlue1.toColor(),
)

class PokedexColors(
    val typeColors: TypeColors,
    val commonColors: CommonColors,
)

val Colors = PokedexColors(
    typeColors = TypeColors(),
    commonColors = CommonColors(),
)

val LocalComposeColor = staticCompositionLocalOf {
    Colors
}

fun preparePokedexColors(): PokedexColors {
    return Colors
}

fun provideComposeColorsProvider(colors: PokedexColors): ProvidedValue<PokedexColors> {
    return LocalComposeColor provides colors
}

object ComposeColorFactory {
    private val colors: PokedexColors
        @Composable
        get() = LocalComposeColor.current

    @Composable
    fun getComposeColors() = colors
}
