package com.dellosaneil.pokedex_mobile.android.ui.pokemonlist

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist.PokemonListViewModel
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.ui.common.CommonTextField
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
    val searchPokemonText = remember { mutableStateOf("") }
    LazyVerticalGrid(
        modifier = Modifier
            .background(color = getComposeColors().commonColors.lightGray1)
            .fillMaxSize(),
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 12.dp),
        userScrollEnabled = !viewState.paginationState.isInitialLoad,
    ) {
        item(span = { GridItemSpan(currentLineSpan = maxLineSpan) }) {
            CommonTextField(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                text = searchPokemonText,
                placeholderRes = R.string.pokemon_list_search_placeholder,
                trailingIcon = R.drawable.close,
                maxLines = 1,
                leadingIcon = R.drawable.search,
            )
        }
        when {
            viewState.paginationState.isInitialLoad -> {
                items(10) {
                    PokemonListLoading(modifier = Modifier.padding(all = 2.dp),
                        angle = angle,
                        imageLoader = imageLoader)
                }
            }
            viewState.paginationState.initialLoadError != null -> {

            }
            else -> {
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
                if (viewState.paginationState.isLoadMore) {
                    repeat(2) {
                        item {
                            PokemonListLoading(
                                modifier = Modifier.padding(all = 2.dp),
                                angle = angle, imageLoader = imageLoader,
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewPokemonListScreen() {
    PokemonListScreen(navigator = EmptyDestinationsNavigator)
}
