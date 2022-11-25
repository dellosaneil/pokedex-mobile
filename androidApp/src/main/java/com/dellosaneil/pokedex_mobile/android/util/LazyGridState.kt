package com.dellosaneil.pokedex_mobile.android.util

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.*

@Composable
fun LazyGridState.isScrollingUp(): Boolean {
    var previousIndex by remember(key1 = this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(key1 = this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(key1 = this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}
