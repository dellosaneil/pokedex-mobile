package com.dellosaneil.pokedex_mobile.android.ui.common

import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.android.util.getColor
import com.dellosaneil.pokedex_mobile.model.common.PokemonType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonTypeChip(
    modifier: Modifier, type: PokemonType,
    onClick: () -> Unit,
    isEnabled: Boolean,
    chipBackground: Color,
) {
    Chip(
        modifier = modifier,
        onClick = onClick,
        colors = ChipDefaults.chipColors(
            backgroundColor = chipBackground,
            contentColor = getComposeColors().commonColors.white,
            disabledBackgroundColor = chipBackground,
            disabledContentColor = getComposeColors().commonColors.white,
        ),
        enabled = isEnabled,
    ) {
        Text(
            text = type.toString(),
            style = getComposeTypography().regular14,

        )
    }
}

@Preview
@Composable
fun PreviewPokemonTypeChip() {
    PokemonTypeChip(
        modifier = Modifier,
        type = PokemonType.getType(12),
        onClick = {},
        isEnabled = false,
        chipBackground = PokemonType.getType(12).getColor(),
    )
}
