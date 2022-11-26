package com.dellosaneil.pokedex_mobile.android.ui.pokemondetail

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.model.pokemondetail.AboutPokemon

@Composable
fun PokemonDetailAboutTab(
    modifier: Modifier, aboutPokemon: AboutPokemon,
) {
    AboutLayout(
        modifier = modifier,
        verticalSpacing = 8.dp,
    ) {
        AboutDetail(textRes = R.string.pokemon_detail_species, value = aboutPokemon.species)
        AboutDetail(textRes = R.string.pokemon_detail_height,
            value = stringResource(id = R.string.pokemon_detail_height_value,
                aboutPokemon.height))
        AboutDetail(textRes = R.string.pokemon_detail_weight,
            value = stringResource(id = R.string.pokemon_detail_weight_value, aboutPokemon.weight))
        AboutDetail(textRes = R.string.pokemon_detail_abilities, value = aboutPokemon.abilities)
        AboutDetail(
            textRes = R.string.pokemon_detail_breeding, value = "",
            style = getComposeTypography().bold20,
            color = getComposeColors().commonColors.black,
        )
        AboutDetail(textRes = R.string.pokemon_detail_gender,
            value = stringResource(id = R.string.pokemon_detail_gender_value,
                aboutPokemon.gender.first,
                aboutPokemon.gender.second))
        AboutDetail(textRes = R.string.pokemon_detail_egg_groups, value = aboutPokemon.eggGroups)
        AboutDetail(textRes = R.string.pokemon_detail_egg_cycle, value = aboutPokemon.eggCycle)
    }
}

@Composable
private fun AboutDetail(
    @StringRes textRes: Int,
    value: String,
    style: TextStyle = getComposeTypography().regular14,
    color: Color = getComposeColors().commonColors.lightGray3,
) {
    Text(
        modifier = Modifier.wrapContentWidth(),
        text = stringResource(id = textRes),
        style = style,
        color = color,
    )
    Text(
        modifier = Modifier.wrapContentWidth(),
        text = value,
        style = getComposeTypography().regular14,
        color = getComposeColors().commonColors.black,
    )
}


@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun PreviewPokemonDetailAboutTab() {
    PokemonDetailAboutTab(
        modifier = Modifier,
        aboutPokemon = AboutPokemon.compose(),
    )
}

@Composable
private fun AboutLayout(
    modifier: Modifier = Modifier,
    verticalSpacing: Dp,
    content: @Composable () -> Unit,
) {
    val density = LocalDensity.current
    val topPadding = density.run { verticalSpacing.toPx() }.toInt()
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints = constraints)
        }
        val height =
            placeables.filterIndexed { index, _ -> index % 2 == 0 }.sumOf { it.height + topPadding }
        val labelWidth = placeables.filterIndexed { index, _ -> index % 2 == 0 }.maxOf { it.width }

        layout(width = constraints.maxWidth, height = height) {
            val startPadding = density.run { 16.dp.toPx() }.toInt()
            var yPosition = 0
            placeables.forEachIndexed { index, placeable ->
                if (index % 2 == 0) {
                    placeable.placeRelative(x = 0, y = yPosition)
                } else {
                    placeable.placeRelative(x = startPadding + labelWidth, y = yPosition)
                    yPosition += placeable.height + topPadding
                }
            }
        }
    }
}
