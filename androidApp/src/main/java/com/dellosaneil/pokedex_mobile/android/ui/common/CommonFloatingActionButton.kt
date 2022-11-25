package com.dellosaneil.pokedex_mobile.android.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors

@Composable
fun CommonFloatingActionButton(
    modifier: Modifier,
    @DrawableRes iconRes: Int,
    iconTint: Color,
    backgroundColor: Color,
    isVisible: Boolean,
    onClick: () -> Unit,
) {
    AnimatedVisibility(visible = isVisible,
        modifier = modifier
            .clip(shape = CircleShape)
            .clickable { onClick() }
            .background(color = backgroundColor)
            .padding(all = 4.dp)
    ) {
        Icon(
            modifier = Modifier.size(size = 24.dp),
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = iconTint,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCommonFloatingActionButton() {
    CommonFloatingActionButton(
        modifier = Modifier,
        iconRes = R.drawable.arrow_up,
        iconTint = Color.White,
        backgroundColor = getComposeColors().commonColors.lightBlue1,
        isVisible = true,
    ) {

    }
}
