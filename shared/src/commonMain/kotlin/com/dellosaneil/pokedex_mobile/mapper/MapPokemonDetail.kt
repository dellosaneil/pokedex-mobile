package com.dellosaneil.pokedex_mobile.mapper

import com.dellosaneil.PokemonDetailQuery
import com.dellosaneil.pokedex_mobile.model.PokemonDetail

interface MapPokemonDetail {
    operator fun invoke(`data` : PokemonDetailQuery.Data?) : PokemonDetail
}
