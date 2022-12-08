package com.dellosaneil.pokedex_mobile.android.mvvm.pokemondetail

import com.dellosaneil.pokedex_mobile.android.mvvm.base.BaseViewState
import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail

data class PokemonDetailViewState(
    val pokemonDetail: PokemonDetail?,
    val throwable: Throwable?,
    val isLoading: Boolean,
) : BaseViewState {
    companion object {
        fun initialState() : PokemonDetailViewState {
            return PokemonDetailViewState(
                pokemonDetail = null,
                throwable = null,
                isLoading = true,
            )
        }
    }
}
