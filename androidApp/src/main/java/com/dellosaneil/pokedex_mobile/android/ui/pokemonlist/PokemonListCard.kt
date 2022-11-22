package com.dellosaneil.pokedex_mobile.android.ui.pokemonlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.android.util.getColor
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon

private val CARD_HEIGHT = 145.dp
private const val IMAGE_HEIGHT_RATIO = 1.5f

@Composable
fun PokemonListCard(
    modifier: Modifier,
    previewPokemon: PreviewPokemon,
    imageLoader: ImageLoader,
) {
    Card(
        modifier = modifier
            .height(height = CARD_HEIGHT),
        shape = RoundedCornerShape(size = 8.dp),
        backgroundColor = previewPokemon.type.first().getColor().copy(alpha = 0.95f),
        elevation = 1.dp,
    ) {
        BoxWithConstraints(modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp)
        ) {
            val maxHeight = (maxHeight.value / IMAGE_HEIGHT_RATIO).toInt().dp
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(weight = 1f),
                    verticalArrangement = Arrangement.spacedBy(space = 16.dp),
                ) {
                    Text(
                        text = previewPokemon.name,
                        style = getComposeTypography().semiBold14,
                        color = getComposeColors().commonColors.white,
                    )
                }
                AsyncImage(
                    modifier = Modifier
                        .heightIn(max = maxHeight)
                        .align(alignment = Alignment.Bottom)
                        .weight(weight = 1f),
                    model = previewPokemon.image,
                    contentDescription = null,
                    imageLoader = imageLoader,
                    contentScale = ContentScale.Fit,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPokemonListCard() {
    PokemonListCard(
        modifier = Modifier
            .padding(16.dp)
            .width(400.dp),
        previewPokemon = PreviewPokemon.compose(),
        imageLoader = ImageLoader(LocalContext.current),
    )
}
