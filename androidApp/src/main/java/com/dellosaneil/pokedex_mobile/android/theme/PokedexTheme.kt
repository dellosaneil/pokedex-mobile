package com.dellosaneil.pokedex_mobile.android.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun PokedexTheme(
    content: @Composable () -> Unit
) {
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )
    ProvideResources {
        MaterialTheme(
            shapes = shapes,
            content = content
        )
    }
}
