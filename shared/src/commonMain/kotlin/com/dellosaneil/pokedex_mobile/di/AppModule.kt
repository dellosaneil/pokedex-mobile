package com.dellosaneil.pokedex_mobile.di

import com.dellosaneil.pokedex_mobile.network.Test
import com.dellosaneil.pokedex_mobile.network.impl.TestImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

fun appModule() = module {
    singleOf(::TestImpl) { bind<Test>() }
}
