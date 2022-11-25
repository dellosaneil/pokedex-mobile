package com.dellosaneil.pokedex_mobile.di

import com.dellosaneil.pokedex_mobile.mapper.MapPokemonDetail
import com.dellosaneil.pokedex_mobile.mapper.impl.MapPokemonDetailImpl
import com.dellosaneil.pokedex_mobile.mapper.MapPreviewPokemon
import com.dellosaneil.pokedex_mobile.mapper.impl.MapPreviewPokemonImpl
import com.dellosaneil.pokedex_mobile.repository.CoreRepository
import com.dellosaneil.pokedex_mobile.repository.impl.CoreRepositoryImpl
import com.dellosaneil.pokedex_mobile.network.CoreService
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonList
import com.dellosaneil.pokedex_mobile.network.usecase.impl.FetchPokemonListImpl
import com.dellosaneil.pokedex_mobile.network.impl.CoreServiceImpl
import com.dellosaneil.pokedex_mobile.network.pagination.PaginationStateHelper
import com.dellosaneil.pokedex_mobile.network.pagination.impl.PaginationStateHelperImpl
import com.dellosaneil.pokedex_mobile.network.pagination.PokedexPagination
import com.dellosaneil.pokedex_mobile.network.pagination.impl.PokedexPaginationImpl
import com.dellosaneil.pokedex_mobile.network.usecase.FetchPokemonDetail
import com.dellosaneil.pokedex_mobile.network.usecase.impl.FetchPokemonDetailImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf

fun appModule() = module {
    singleOf(::PaginationStateHelperImpl) { bind<PaginationStateHelper>() }
}

fun networkModule() = module {
    singleOf(::CoreServiceImpl) { bind<CoreService>() }
    singleOf(::CoreRepositoryImpl) { bind<CoreRepository>() }

    factoryOf(::FetchPokemonListImpl) { bind<FetchPokemonList>() }
    factoryOf(::MapPreviewPokemonImpl) { bind<MapPreviewPokemon>() }
    factoryOf(::PokedexPaginationImpl) { bind<PokedexPagination>() }
    factoryOf(::MapPokemonDetailImpl) { bind<MapPokemonDetail>() }
    factoryOf(::FetchPokemonDetailImpl) { bind<FetchPokemonDetail>() }
}
