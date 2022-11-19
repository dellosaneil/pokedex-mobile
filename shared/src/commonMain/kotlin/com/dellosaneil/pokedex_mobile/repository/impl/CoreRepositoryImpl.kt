package com.dellosaneil.pokedex_mobile.repository.impl

import com.dellosaneil.PokemonListQuery
import com.dellosaneil.pokedex_mobile.mapper.MapPreviewPokemon
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import com.dellosaneil.pokedex_mobile.network.CoreService
import com.dellosaneil.pokedex_mobile.repository.CoreRepository
import org.koin.core.component.KoinComponent

class CoreRepositoryImpl(
    private val coreService: CoreService,
    private val mapPreviewPokemon: MapPreviewPokemon,
) : KoinComponent, CoreRepository {

    override suspend fun fetchPokemonList(): List<PreviewPokemon> {
        val data = coreService().query(PokemonListQuery()).execute().data
        return mapPreviewPokemon(data = data)
    }
}
