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
import coil.decode.SvgDecoder
import coil.disk.DiskCache
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.android.util.getColor
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

private val CARD_HEIGHT = 145.dp


@Composable
fun PokemonListCard(
    modifier: Modifier,
    previewPokemon: PreviewPokemon,
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .height(CARD_HEIGHT),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = previewPokemon.type.first().getColor().copy(alpha = 0.95f),
        elevation = 1.dp,
    ) {
        BoxWithConstraints(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp, vertical = 16.dp)
        ) {
            val imageWidth = (maxWidth / 2)
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
                        style = getComposeTypography().semiBold16,
                        color = getComposeColors().commonColors.white,
                    )
                }
                val imageLoader = ImageLoader.Builder(context)
                    .components {
                        add(SvgDecoder.Factory())
                    }.diskCache {
                        DiskCache.Builder()
                            .directory(context.cacheDir.resolve("image_cache"))
                            .build()
                    }
                    .build()
                CoilImage(
                    imageModel = { previewPokemon.image },
                    modifier = Modifier
                        .width(width = imageWidth)
                        .align(alignment = Alignment.Bottom)
                        .weight(weight = 1f),
                    previewPlaceholder = R.drawable.ivysaur,
                    imageLoader = { imageLoader },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Fit,
                    )
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
    )
}
