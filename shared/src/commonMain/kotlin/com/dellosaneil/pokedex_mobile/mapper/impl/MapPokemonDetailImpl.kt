package com.dellosaneil.pokedex_mobile.mapper.impl

import com.dellosaneil.PokemonDetailQuery
import com.dellosaneil.pokedex_mobile.mapper.MapPokemonDetail
import com.dellosaneil.pokedex_mobile.model.pokemondetail.PokemonDetail
import com.dellosaneil.pokedex_mobile.model.common.PokemonType
import com.dellosaneil.pokedex_mobile.model.pokemondetail.AboutPokemon
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class MapPokemonDetailImpl : MapPokemonDetail {

    companion object {
        private const val VERSIONS_KEY = "versions"
        private const val GENERATION_5_KEY = "generation-v"
        private const val BLACK_AND_WHITE_KEY = "black-white"
        private const val ANIMATED_KEY = "animated"
        private const val FRONT_DEFAULT_KEY = "front_default"
    }

    override fun invoke(data: PokemonDetailQuery.Data?): PokemonDetail {
        val pokemonDetail = with(data?.pokemon_v2_pokemon?.first()!!) {
            val spriteList = pokemon_v2_pokemonsprites.map {
                it.sprites
            }.first()
            val jsonElement = Json.parseToJsonElement(spriteList)
            val versions = jsonElement.jsonObject[VERSIONS_KEY]
            val jsonGen5 = versions!!.jsonObject[GENERATION_5_KEY]
            val blackWhite = jsonGen5!!.jsonObject[BLACK_AND_WHITE_KEY]
            val jsonAnimated = blackWhite!!.jsonObject[ANIMATED_KEY]
            val gif = jsonAnimated?.jsonObject?.get(FRONT_DEFAULT_KEY)?.jsonPrimitive?.content ?: ""
            val genderRate = pokemon_v2_pokemonspecy?.gender_rate ?: 0
            val femaleRate = (genderRate / 8f) * 100f
            val maleRate = 100 - femaleRate
            val genderRatio = maleRate to femaleRate
            val abilities = pokemon_v2_pokemonabilities.map {
                it.pokemon_v2_ability?.name
            }.mapNotNull { abilityName ->
                abilityName?.replace(oldChar = '-', newChar = ' ')
                    ?.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            }.joinToString(separator = ", ")
            PokemonDetail(
                name = name,
                image = gif,
                pokemonType = pokemon_v2_pokemontypes.map {
                    PokemonType.getType(id = it.type_id ?: 0)
                },
                stat = pokemon_v2_pokemonstats.map { it.base_stat },
                aboutPokemon = AboutPokemon(
                    height = height?.times(10f) ?: 0f,
                    weight = weight?.div(10f) ?: 0f,
                    abilities = abilities,
                    gender = genderRatio,
                    captureRate = pokemon_v2_pokemonspecy?.capture_rate ?: 0,
                    baseHappiness = pokemon_v2_pokemonspecy?.base_happiness ?: 0,
                )
            )
        }
        return pokemonDetail
    }
}
