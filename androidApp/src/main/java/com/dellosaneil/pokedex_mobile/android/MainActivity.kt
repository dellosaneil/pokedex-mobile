package com.dellosaneil.pokedex_mobile.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.dellosaneil.pokedex_mobile.android.theme.PokedexTheme
import com.dellosaneil.pokedex_mobile.android.ui.NavGraphs
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostEngine = rememberAnimatedNavHostEngine()
            PokedexTheme {
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                    engine = navHostEngine,
                )
            }
        }
    }
}
