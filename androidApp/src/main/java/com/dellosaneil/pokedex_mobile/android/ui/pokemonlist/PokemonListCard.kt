package com.dellosaneil.pokedex_mobile.android.ui.pokemonlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.android.ui.common.PokemonTypeChip
import com.dellosaneil.pokedex_mobile.android.util.getColor
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon

val CARD_HEIGHT = 145.dp
private const val IMAGE_HEIGHT_RATIO = 1.5f

@Composable
fun PokemonListCard(
    modifier: Modifier,
    previewPokemon: PreviewPokemon,
    imageLoader: ImageLoader,
    angle: Float,
    onPokemonClicked: (Int, Color) -> Unit,
) {
    val backgroundColor = previewPokemon.type.first().getColor()
    val isFinished = remember { mutableStateOf(false) }
    BoxWithConstraints(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .clickable {
                onPokemonClicked(previewPokemon.id, backgroundColor)
            }
            .background(color = backgroundColor
                .copy(alpha = 0.85f))
            .padding(all = 8.dp)
            .height(height = CARD_HEIGHT),
    ) {
        val maxHeight = (maxHeight.value / IMAGE_HEIGHT_RATIO).toInt().dp
        Row(
            modifier = Modifier
                .padding(all = 4.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(weight = 1f),
            ) {
                Text(
                    text = previewPokemon.name,
                    style = getComposeTypography().semiBold14,
                    color = getComposeColors().commonColors.white,
                )
                Spacer(modifier = Modifier.height(16.dp))
                previewPokemon.type.forEach { pokemonType ->
                    PokemonTypeChip(
                        modifier = Modifier,
                        type = pokemonType,
                        chipBackground = backgroundColor,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(alignment = Alignment.Bottom)
                    .weight(weight = 1f),
                contentAlignment = Alignment.BottomCenter,
            ) {
                AsyncImage(
                    model = R.drawable.pokeball, contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            if (!isFinished.value) {
                                rotationZ = angle
                            }
                        },
                    colorFilter = ColorFilter.tint(color = getComposeColors().commonColors.lightGray1),
                    imageLoader = imageLoader,
                )
                AsyncImage(
                    modifier = Modifier
                        .heightIn(max = maxHeight),
                    model = previewPokemon.image,
                    contentDescription = null,
                    imageLoader = imageLoader,
                    contentScale = ContentScale.Fit,
                    onLoading = {
                        isFinished.value = false
                    },
                    onSuccess = {
                        isFinished.value = true
                    },
                    onError = {
                        isFinished.value = false
                    }
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
        angle = 0f,
    ) { _, _ ->

    }
}
