package com.dellosaneil.pokedex_mobile.network.usecase.impl

import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import com.dellosaneil.pokedex_mobile.repository.CoreRepository
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonList

class FetchPokemonListImpl(private val repository: CoreRepository) : FetchPokemonList {

    override suspend fun invoke(isInitialLoad: Boolean): List<PreviewPokemon> {
        return repository.fetchPokemonList(isInitialLoad = isInitialLoad)
    }
}
