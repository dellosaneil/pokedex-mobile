package com.dellosaneil.pokedex_mobile.android.mvvm.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel<ViewState : BaseViewState, ViewEffect : BaseViewEffect> : ViewModel() {
    private val initialState: ViewState by lazy {
        initialState()
    }

    abstract fun initialState(): ViewState

    private val _viewState = MutableStateFlow(initialState)
    val viewState = _viewState.asStateFlow()

    private val viewEffectChannel = Channel<ViewEffect>()
    val viewEffectFlow = viewEffectChannel.receiveAsFlow()

    fun getCurrentState(): ViewState {
        return viewState.value
    }

    fun updateViewState(updatedViewState: ViewState) {
        _viewState.value = updatedViewState
    }

    suspend fun emitViewEffect(effect: ViewEffect) {
        viewEffectChannel.send(element = effect)
    }
}
