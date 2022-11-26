package com.dellosaneil.pokedex_mobile.android.ui.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.dellosaneil.pokedex_mobile.android.R
import com.dellosaneil.pokedex_mobile.android.theme.ComposeColorFactory.getComposeColors
import com.dellosaneil.pokedex_mobile.android.theme.ComposeTypographyFactory.getComposeTypography
import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PokemonDetailBottomBar(
    modifier: Modifier,
    coroutineScope: CoroutineScope,
    pokemonDetail: PokemonDetail,
) {
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
                .padding(top = 8.dp)
                .fillMaxWidth(),
            state = pagerState,
        ) { page ->
            when (page) {
                BottomBarItems.ABOUT.index -> {
                    PokemonDetailAboutTab(
                        modifier = Modifier.padding(start = 16.dp, end  = 16.dp, top = 8.dp, bottom = 8.dp,),
                        aboutPokemon = pokemonDetail.aboutPokemon,
                    )
                }
                BottomBarItems.BASE_STATS.index -> {
                    Text(text = "1", modifier = Modifier.fillMaxWidth())
                }
                BottomBarItems.EVOLUTION.index -> {
                    Text(text = "2")
                }
                BottomBarItems.MOVES.index -> {
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
        pokemonDetail = PokemonDetail.compose(),
    )
}

private enum class BottomBarItems(val index: Int) {
    ABOUT(index = 0),
    BASE_STATS(index = 1),
    EVOLUTION(index = 2),
    MOVES(index = 3),
}
