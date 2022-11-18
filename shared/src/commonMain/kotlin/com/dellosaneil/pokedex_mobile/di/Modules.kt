package com.dellosaneil.pokedex_mobile.di

import com.dellosaneil.pokedex_mobile.network.CoreRepository
import com.dellosaneil.pokedex_mobile.network.impl.CoreRepositoryImpl
import com.dellosaneil.pokedex_mobile.network.CoreService
import com.dellosaneil.pokedex_mobile.network.FetchPokemonList
import com.dellosaneil.pokedex_mobile.network.impl.FetchPokemonListImpl
import com.dellosaneil.pokedex_mobile.network.impl.CoreServiceImpl
import com.dellosaneil.pokedex_mobile.network.Test
import com.dellosaneil.pokedex_mobile.network.impl.TestImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf

fun appModule() = module {
    singleOf(::TestImpl) { bind<Test>() }
}

fun networkModule() = module {
    singleOf(::CoreServiceImpl) { bind<CoreService>() }
    singleOf(::CoreRepositoryImpl) { bind<CoreRepository>() }
    factoryOf(::FetchPokemonListImpl) { bind<FetchPokemonList>() }
}
