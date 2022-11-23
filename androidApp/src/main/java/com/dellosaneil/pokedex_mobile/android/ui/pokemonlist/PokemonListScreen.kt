package com.dellosaneil.pokedex_mobile.android.ui.pokemonlist

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist.PokemonListViewModel
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.util.defaultImageLoader
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import org.koin.androidx.compose.koinViewModel


private const val DURATION_MILLIS_LOADING = 7500

@RootNavGraph(start = true)
@Destination
@Composable
fun PokemonListScreen(
    navigator: DestinationsNavigator,
) {
    val context = LocalContext.current
    val viewModel: PokemonListViewModel = koinViewModel()
    val viewState by viewModel.viewState.collectAsState()
    val imageLoader = defaultImageLoader(context = context)
    val infiniteTransition = rememberInfiniteTransition()
    val angle: Float by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = DURATION_MILLIS_LOADING, easing = LinearEasing)
        )
    )
    LazyVerticalGrid(
        modifier = Modifier
            .background(color = getComposeColors().commonColors.white)
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 12.dp)
    ) {
        items(items = viewState.pokemonList, key = { it.id }) { pokemon ->
            PokemonListCard(
                modifier = Modifier.padding(all = 2.dp),
                previewPokemon = pokemon,
                imageLoader = imageLoader,
                angle = angle,
            )
            if (pokemon.id == viewState.pokemonList.last().id) {
                viewModel.retrievePokemonList(isInitialLoad = false)
            }
        }
    }
}


@Preview
@Composable
fun PreviewPokemonListScreen() {
    PokemonListScreen(navigator = EmptyDestinationsNavigator)
}
