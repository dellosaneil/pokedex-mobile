package com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist

import androidx.lifecycle.viewModelScope
import com.dellosaneil.pokedex_mobile.android.mvvm.base.BaseViewModel
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PokemonListViewModel(private val fetchPokemonList: FetchPokemonList) :
    BaseViewModel<PokemonListViewState, PokemonListViewEffect>() {

    override fun initialState() = PokemonListViewState.initialState()

    init {
        retrievePokemonList()
    }


    private fun retrievePokemonList() {
        viewModelScope.launch {
            flow {
                val pokemonList = fetchPokemonList()
                emit(pokemonList)
            }.onStart {
                updateViewState(updatedViewState = viewState.value.copy(
                    isLoading = true,
                    throwable = null,
                ))
            }.catch {
                updateViewState(updatedViewState = viewState.value.copy(
                    isLoading = false,
                    throwable = it.cause,
                ))
            }.flowOn(Dispatchers.IO)
                .collect {
                    updateViewState(updatedViewState = viewState.value.copy(
                        pokemonList = it,
                        throwable = null,
                        isLoading = false,
                    ))
                }
        }
    }
}
