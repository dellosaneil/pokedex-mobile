package com.dellosaneil.pokedex_mobile.mapper.impl

import com.dellosaneil.PokemonListQuery
import com.dellosaneil.pokedex_mobile.mapper.MapPreviewPokemon
import com.dellosaneil.pokedex_mobile.model.common.Type
import com.dellosaneil.pokedex_mobile.model.pokemonlist.PreviewPokemon
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class MapPreviewPokemonImpl : MapPreviewPokemon {

    companion object {
        private const val POKEMON_IMAGE_KEY = "front_default"
    }


    override fun invoke(data: PokemonListQuery.Data?): List<PreviewPokemon> {
        return data?.pokemon_v2_pokemon?.map { pokemon ->
            val spriteList = pokemon.pokemon_v2_pokemonsprites.map {
                it.sprites
            }.first()
            val jsonElement = Json.parseToJsonElement(spriteList)
            val image = jsonElement.jsonObject[POKEMON_IMAGE_KEY]?.jsonPrimitive?.content ?: ""
            PreviewPokemon(
                name = pokemon.name,
                type = pokemon.pokemon_v2_pokemontypes.map {
                    Type.getType(id = it.type_id ?: 0)
                },
                image = image,
            )
        } ?: emptyList()
    }
}
