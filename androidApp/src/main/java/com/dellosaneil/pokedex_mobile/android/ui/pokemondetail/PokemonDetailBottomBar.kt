package com.dellosaneil.pokedex_mobile.android.ui.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PokemonDetailBottomBar(modifier: Modifier, coroutineScope: CoroutineScope) {
    val pagerState = rememberPagerState(pageCount = 4)
    Column(
        modifier = modifier.clip(shape = RoundedCornerShape(topStartPercent = 8,
            topEndPercent = 8)))
    {
        TabRow(
            modifier = Modifier,
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(
                        pagerState = pagerState,
                        tabPositions = tabPositions,
                    )
                )
            },
            backgroundColor = getComposeColors().commonColors.white,
        ) {
            val pages = stringArrayResource(R.array.pokemon_detail_pager)
            pages.forEachIndexed { index, label ->
                Tab(
                    text = {
                        Text(
                            text = label,
                            style = getComposeTypography().regular14,
                            color = getComposeColors().commonColors.black,
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page = index)
                        }
                    }
                )
            }
        }
        HorizontalPager(
            modifier = Modifier
                .background(color = getComposeColors().commonColors.white)
                .fillMaxWidth(),
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> {
                    Text(text = "0")
                }
                1 -> {
                    Text(text = "1")
                }
                2 -> {
                    Text(text = "2")
                }
                3 -> {
                    Text(text = "3")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPokemonDetailBottomBar() {
    PokemonDetailBottomBar(
        modifier = Modifier.fillMaxWidth(),
        coroutineScope = rememberCoroutineScope(),
    )
}
