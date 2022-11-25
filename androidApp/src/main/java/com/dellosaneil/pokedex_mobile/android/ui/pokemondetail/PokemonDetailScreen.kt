package com.dellosaneil.pokedex_mobile.android.ui.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.ui.transitions.PokedexTransitions
import com.ramcosta.composedestinations.annotation.Destination

@Destination(style = PokedexTransitions::class)
@Composable
fun PokemonDetailScreen() {
    Box(modifier = Modifier
        .background(color = getComposeColors().commonColors.lightGray1)
        .fillMaxSize()) {

    }
}

@Preview
@Composable
fun PreviewPokemonDetailScreen() {
    PokemonDetailScreen()
}
