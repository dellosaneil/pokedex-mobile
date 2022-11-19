package com.dellosaneil.pokedex_mobile.android

import android.app.Application
import com.dellosaneil.pokedex_mobile.di.appModule
import com.dellosaneil.pokedex_mobile.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class PokedexApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(androidContext = this@PokedexApplication)
            androidLogger()
            modules(listOf(appModule(), networkModule()))
        }
    }
}
