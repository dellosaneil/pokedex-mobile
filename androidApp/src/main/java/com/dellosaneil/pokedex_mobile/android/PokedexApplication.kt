package com.dellosaneil.pokedex_mobile.android

import android.app.Application
import com.dellosaneil.pokedex_mobile.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokedexApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@PokedexApplication)
            androidLogger()
            modules(appModule())
        }
    }
}
