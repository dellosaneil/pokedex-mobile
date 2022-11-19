package com.dellosaneil.pokedex_mobile.android.di

import com.dellosaneil.pokedex_mobile.android.mvvm.pokemonlist.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel { PokemonListViewModel(get()) }
}
