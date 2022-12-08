package com.dellosaneil.pokedex_mobile.mapper.impl

import com.dellosaneil.PokemonDetailQuery
import com.dellosaneil.pokedex_mobile.mapper.MapPokemonDetail
import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail
import com.dellosaneil.pokedex_mobile.model.common.PokemonType
import com.dellosaneil.pokedex_mobile.model.pokemondetail.AboutPokemon

class MapPokemonDetailImpl : MapPokemonDetail {
    override fun invoke(data: PokemonDetailQuery.Data?): PokemonDetail {
        val pokemonDetail = with(data?.pokemon_v2_pokemon?.first()!!) {
            val genderRate = pokemon_v2_pokemonspecy?.gender_rate ?: 0
            val genderRatio = (genderRate / 8f) to ((genderRate / 8f) - 100)
            val abilities = pokemon_v2_pokemonabilities.map {
                it.pokemon_v2_ability?.name
            }.mapNotNull {
                it
            }.joinToString(separator = ",")
            PokemonDetail(
                name = name,
                image = pokemon_v2_pokemonsprites.first().sprites,
                pokemonType = pokemon_v2_pokemontypes.map {
                    PokemonType.getType(id = it.type_id ?: 0)
                },
                stat = pokemon_v2_pokemonstats.map { it.base_stat },
                aboutPokemon = AboutPokemon(
                    height = height ?: 0,
                    weight = weight ?: 0,
                    abilities = abilities,
                    gender = genderRatio,
                    species = "",
                    eggGroups = "",
                    eggCycle = "",
                )
            )
        }
        return pokemonDetail
    }
}
