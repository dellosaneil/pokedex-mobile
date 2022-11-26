package com.dellosaneil.pokedex_mobile.network.usecase.impl

import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonDetail
import com.dellosaneil.pokedex_mobile.repository.CoreRepository

class FetchPokemonDetailImpl(private val repository: CoreRepository,) : FetchPokemonDetail {
    override suspend fun invoke(id: Int): PokemonDetail {
        return repository.fetchPokemonDetail(id = id)
    }
}
