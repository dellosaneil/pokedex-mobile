package com.dellosaneil.pokedex_mobile.mapper.impl

import com.dellosaneil.PokemonDetailQuery
import com.dellosaneil.pokedex_mobile.mapper.MapPokemonDetail
import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail
import com.dellosaneil.pokedex_mobile.model.common.PokemonType
import com.dellosaneil.pokedex_mobile.model.pokemondetail.AboutPokemon

class MapPokemonDetailImpl : MapPokemonDetail {
    override fun invoke(data: PokemonDetailQuery.Data?): PokemonDetail {
        val pokemonDetail = with(data?.pokemon_v2_pokemon?.first()!!) {
            PokemonDetail(
                name = name,
                image = pokemon_v2_pokemonsprites.first().sprites,
                pokemonType = pokemon_v2_pokemontypes.map {
                    PokemonType.getType(id = it.type_id ?: 0)
                },
                stat = pokemon_v2_pokemonstats.map { it.base_stat },
                aboutPokemon = AboutPokemon.compose(),
                )
        }
        return pokemonDetail
    }
}
