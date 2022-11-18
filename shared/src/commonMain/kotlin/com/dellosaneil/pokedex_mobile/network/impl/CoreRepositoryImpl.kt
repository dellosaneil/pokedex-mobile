package com.dellosaneil.pokedex_mobile.network.impl

import com.dellosaneil.PokemonListQuery
import com.dellosaneil.pokedex_mobile.model.common.Type
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import com.dellosaneil.pokedex_mobile.network.CoreRepository
import com.dellosaneil.pokedex_mobile.network.CoreService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CoreRepositoryImpl(
) : KoinComponent, CoreRepository {
    private val coreService: CoreService by inject()

    override suspend fun fetchPokemonList(): List<PreviewPokemon> {
        val query = coreService().query(PokemonListQuery()).execute()
        return query.data?.pokemon_v2_pokemon?.map { pokemon ->
            PreviewPokemon(name = pokemon.name, type = pokemon.pokemon_v2_pokemontypes.map {
                Type.getType(id = it.type_id ?: 0)
            })
        } ?: emptyList()
    }
}
