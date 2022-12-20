package com.dellosaneil.pokedex_mobile.android.mvvm.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

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

    private fun updateViewState(updatedViewState: ViewState) {
        _viewState.value = updatedViewState
    }

    suspend fun emitViewEffect(effect: ViewEffect) {
        viewEffectChannel.send(element = effect)
    }

    fun runFunction(
        successBlock: suspend () -> ViewState,
        errorBlock: (Throwable) -> ViewState,
        loadingBlock: () -> ViewState,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                updateViewState(updatedViewState = loadingBlock())
                updateViewState(updatedViewState = successBlock())
            } catch (e: Exception) {
                Timber.e(e)
                updateViewState(errorBlock(e))
            }
        }
    }

    fun runFunction(
        successBlock: suspend () -> ViewState,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            updateViewState(updatedViewState = successBlock())
        }
    }

    fun runFunction(
        successBlock: suspend () -> ViewState,
        loadingBlock: () -> ViewState,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            updateViewState(updatedViewState = loadingBlock())
            updateViewState(updatedViewState = successBlock())
        }
    }
}
