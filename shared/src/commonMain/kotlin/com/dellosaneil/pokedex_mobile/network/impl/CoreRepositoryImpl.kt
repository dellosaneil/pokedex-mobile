package com.dellosaneil.pokedex_mobile.network.impl

import com.dellosaneil.PokemonQuery
import com.dellosaneil.pokedex_mobile.network.CoreRepository
import com.dellosaneil.pokedex_mobile.network.CoreService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CoreRepositoryImpl(
) : KoinComponent, CoreRepository {
    private val coreService: CoreService by inject()

    override suspend fun fetchPokemonList() {
        coreService().query(PokemonQuery()).execute().data

    }
}
