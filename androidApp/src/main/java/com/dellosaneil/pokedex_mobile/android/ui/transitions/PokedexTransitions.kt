package com.dellosaneil.pokedex_mobile.android.ui.transitions

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(ExperimentalAnimationApi::class)
object PokedexTransitions : DestinationStyle.Animated {
    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition {
        return slideInHorizontally(animationSpec = tween(durationMillis = 250),
            initialOffsetX = { -1000 }
        )
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition {
        return slideOutHorizontally(animationSpec = tween(durationMillis = 250),
            targetOffsetX = { 1000 }
        )

    }

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition {
        return slideInHorizontally(animationSpec = tween(durationMillis = 250),
            initialOffsetX = { -1000 }
        )
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popExitTransition(): ExitTransition {
        return slideOutHorizontally(animationSpec = tween(durationMillis = 250),
            targetOffsetX = { 1000 }
        )
    }
}
