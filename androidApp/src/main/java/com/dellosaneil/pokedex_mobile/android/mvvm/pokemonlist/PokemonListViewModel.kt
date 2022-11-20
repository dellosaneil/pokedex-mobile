package com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist

import com.dellosaneil.pokedex_mobile.android.mvvm.base.BaseViewModel
import com.dellosaneil.pokedex_mobile.network.pagination.PaginationStateHelper
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonList

class PokemonListViewModel(
    private val fetchPokemonList: FetchPokemonList,
    private val paginationStateHelper: PaginationStateHelper,
) :
    BaseViewModel<PokemonListViewState, PokemonListViewEffect>() {

    override fun initialState() = PokemonListViewState.initialState()

    init {
        retrievePokemonList(isInitialLoad = true)
    }

    private fun retrievePokemonList(isInitialLoad: Boolean) {
        runFunction(
            successBlock = {
                val newPokemonList = fetchPokemonList(isInitialLoad = isInitialLoad)
                val pokemonList = if(isInitialLoad) {
                    newPokemonList
                } else {
                    val newList = getCurrentState().pokemonList.toMutableList()
                    newList.addAll(newPokemonList)
                    newList
                }

                getCurrentState().copy(
                    pokemonList = pokemonList,
                    paginationState = paginationStateHelper.success(
                        isInitialLoad = isInitialLoad,
                    )
                )
            }, errorBlock = { throwable ->
                getCurrentState().copy(
                    paginationState = paginationStateHelper.error(
                        isInitialLoad = isInitialLoad,
                        throwable = throwable,
                    )
                )
            }, loadingBlock = {
                getCurrentState().copy(
                    paginationState = paginationStateHelper.loading(
                        isInitialLoad = isInitialLoad,
                    )
                )
            }
        )
    }
}
