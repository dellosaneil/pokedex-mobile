package com.dellosaneil.pokedex_mobile.android.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun ProvideResources(
    content: @Composable () -> Unit
) {
    val pokedexColors = remember {
        preparePokedexColors()
    }

    CompositionLocalProvider(
        provideComposeColorsProvider(pokedexColors),
        provideComposeTypographyProvider(),
        content = content
    )
}

