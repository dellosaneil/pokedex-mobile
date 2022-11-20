package com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist

import com.dellosaneil.pokedex_mobile.android.mvvm.base.BaseViewState
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import com.dellosaneil.pokedex_mobile.network.pagination.PaginationState

data class PokemonListViewState(
    val pokemonList: List<PreviewPokemon>,
    val paginationState: PaginationState,
) : BaseViewState {
    companion object {
        fun initialState(): PokemonListViewState {
            return PokemonListViewState(
                pokemonList = emptyList(),
                paginationState = PaginationState.initialState(),
            )
        }
    }
}
