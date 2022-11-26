package com.dellosaneil.pokedex_mobile.network.usecase

import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail

interface FetchPokemonDetail {
    suspend operator fun invoke(id: Int) : PokemonDetail
}
