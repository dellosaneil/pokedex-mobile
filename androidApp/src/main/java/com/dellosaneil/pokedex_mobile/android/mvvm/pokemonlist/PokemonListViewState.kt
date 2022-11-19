package com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist

import com.dellosaneil.pokedex_mobile.android.mvvm.base.BaseViewState
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon

data class PokemonListViewState(
    val pokemonList: List<PreviewPokemon>,
    val throwable: Throwable?,
    val isLoading: Boolean,
) : BaseViewState {
    companion object {
        fun initialState(): PokemonListViewState {
            return PokemonListViewState(
                pokemonList = emptyList(),
                isLoading = true,
                throwable = null,
            )
        }
    }
}
