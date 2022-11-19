package com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist

import com.dellosaneil.pokedex_mobile.android.mvvm.base.BaseViewModel
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonList

class PokemonListViewModel(private val fetchPokemonList: FetchPokemonList) :
    BaseViewModel<PokemonListViewState, PokemonListViewEffect>() {

    override fun initialState() = PokemonListViewState.initialState()

    init {
        retrievePokemonList()
    }


    private fun retrievePokemonList() {
        runFunction(
            successBlock = {
                val pokemonList = fetchPokemonList()
                getCurrentState().copy(
                    pokemonList = pokemonList, isLoading = false,
                    throwable = null,
                )
            }, errorBlock = { throwable ->
                getCurrentState().copy(
                    throwable = throwable,
                    isLoading = false,
                )
            }, loadingBlock = {
                getCurrentState().copy(
                    throwable = null,
                    isLoading = true,
                )
            }
        )
    }
}
