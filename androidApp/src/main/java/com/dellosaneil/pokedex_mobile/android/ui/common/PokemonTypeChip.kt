package com.dellosaneil.pokedex_mobile.android.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.android.util.getColor
import com.dellosaneil.pokedex_mobile.model.common.PokemonType

@Composable
fun PokemonTypeChip(
    modifier: Modifier, type: PokemonType,
    onClick: (() -> Unit)? = null,
    chipBackground: Color,
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(color = chipBackground)
            .clickable(
                enabled = onClick != null,
                onClick = { onClick?.invoke() },
            ),
    ) {
        Text(
            text = type.toString(),
            style = getComposeTypography().regular12,
            color = getComposeColors().commonColors.white,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp,)
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
        chipBackground = PokemonType.getType(12).getColor(),
    )
}
