package com.dellosaneil.pokedex_mobile.android.mvvm.pokemondetail

import com.dellosaneil.pokedex_mobile.android.mvvm.base.BaseViewModel
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonDetail

class PokemonDetailViewModel(
    private val fetchPokemonDetail: FetchPokemonDetail,
) : BaseViewModel<PokemonDetailViewState, PokemonDetailViewEffect>() {
    override fun initialState() = PokemonDetailViewState.initialState()


    fun retrievePokemonDetail(id: Int) {
        runFunction(successBlock = {
            val pokemonDetail = fetchPokemonDetail(id = id)
            getCurrentState().copy(
                pokemonDetail = pokemonDetail,
                isLoading = false,
                throwable = null,
            )
        },
            errorBlock = {
                getCurrentState().copy(
                    throwable = it,
                    isLoading = false,
                )
            },
            loadingBlock = {
                getCurrentState().copy(
                    isLoading = true,
                    throwable = null,
                )
            }
        )
    }
}
