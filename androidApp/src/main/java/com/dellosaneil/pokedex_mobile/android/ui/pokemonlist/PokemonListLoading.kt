package com.dellosaneil.pokedex_mobile.android.ui.pokemonlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors

@Composable
fun PokemonListLoading(
    modifier: Modifier,
    angle: Float,
    imageLoader: ImageLoader,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = getComposeColors().commonColors.white)
            .padding(all = 8.dp)
            .height(height = CARD_HEIGHT),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            model = R.drawable.pokeball, contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationZ = angle
                },
            colorFilter = ColorFilter.tint(color = getComposeColors().commonColors.lightGray1),
            imageLoader = imageLoader,
        )
    }
}

@Preview
@Composable
fun PreviewPokemonListLoading() {
    PokemonListLoading(modifier = Modifier.width(250.dp), angle = 0f, imageLoader = ImageLoader(
        LocalContext.current))
}
