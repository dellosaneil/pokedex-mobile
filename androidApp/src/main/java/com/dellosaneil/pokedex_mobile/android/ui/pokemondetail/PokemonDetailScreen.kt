package com.dellosaneil.pokedex_mobile.android.ui.pokemondetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.mvvm.pokemondetail.PokemonDetailViewModel
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.android.ui.common.PokemonTypeChip
import com.dellosaneil.pokedex_mobile.android.ui.transitions.PokedexTransitions
import com.dellosaneil.pokedex_mobile.android.util.defaultImageLoader
import com.dellosaneil.pokedex_mobile.android.util.getColor
import com.dellosaneil.pokedex_mobile.android.util.toColor
import com.dellosaneil.pokedex_mobile.model.common.PokemonType
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination(style = PokedexTransitions::class)
@Composable
fun PokemonDetailScreen(
    id: Int, backgroundColor: Long,
    navigator: DestinationsNavigator,
) {

    val viewModel: PokemonDetailViewModel = koinViewModel()
    val viewState by viewModel.viewState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.retrievePokemonDetail(id = id)
    }

    val context = LocalContext.current
    val imageLoader = defaultImageLoader(context = context)
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = null,
                tint = getComposeColors().commonColors.white,
                modifier = Modifier
                    .padding(20.dp)
                    .clip(shape = RoundedCornerShape(size = 4.dp))
                    .clickable {
                        navigator.navigateUp()
                    }
            )
        },
        backgroundColor = backgroundColor.toColor().copy(alpha = 0.80f),
        bottomBar = {
            if(viewState.pokemonDetail != null) {
                PokemonDetailBottomBar(
                    modifier = Modifier.fillMaxWidth(),
                    coroutineScope = coroutineScope,
                    pokemonDetail = viewState.pokemonDetail!!,
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp),
        ) {
            Text(
                text = viewState.pokemonDetail?.name ?: "",
                style = getComposeTypography().bold28,
                color = getComposeColors().commonColors.white,
            )
            Row(horizontalArrangement = Arrangement.spacedBy(space = 8.dp)) {
                viewState.pokemonDetail?.pokemonType?.forEach { pokemonType ->
                    PokemonTypeChip(
                        modifier = Modifier,
                        type = pokemonType,
                        chipBackground = backgroundColor.toColor(),
                    )
                }
            }
            BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                val imageWidth = maxWidth / 2
                AsyncImage(
                    modifier = Modifier
                        .size(size = imageWidth)
                        .align(alignment = Alignment.Center),
                    model = viewState.pokemonDetail?.image ?: "",
                    contentDescription = null,
                    imageLoader = imageLoader,
                    contentScale = ContentScale.Fit,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPokemonDetailScreen() {
    PokemonDetailScreen(
        id = 0,
        backgroundColor = PokemonType.getType(12).getColor().toArgb().toLong(),
        navigator = EmptyDestinationsNavigator,
    )
}
