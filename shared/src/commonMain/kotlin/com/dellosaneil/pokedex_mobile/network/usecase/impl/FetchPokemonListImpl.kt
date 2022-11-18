package com.dellosaneil.pokedex_mobile.network.usecase.impl

import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import com.dellosaneil.pokedex_mobile.network.CoreRepository
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FetchPokemonListImpl : KoinComponent,
    FetchPokemonList {
    private val repository: CoreRepository by inject()

    override suspend fun invoke() : List<PreviewPokemon> {
        return repository.fetchPokemonList()
    }
}
