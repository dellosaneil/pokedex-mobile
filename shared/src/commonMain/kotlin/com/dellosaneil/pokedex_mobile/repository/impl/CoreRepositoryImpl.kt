package com.dellosaneil.pokedex_mobile.repository.impl

import com.apollographql.apollo3.api.Optional
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
        val data =
            coreService().query(query = PokemonListQuery(limit = Optional.Present(1), offset = Optional.Present(1))).execute().data
        return mapPreviewPokemon(data = data)
    }
}
