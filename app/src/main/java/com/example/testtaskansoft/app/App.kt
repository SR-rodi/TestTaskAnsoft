package com.example.testtaskansoft.app

import android.app.Application
import com.example.testtaskansoft.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    networkModule,
                    useCaseModule,
                    providerModule,
                    dataBaseModule
                )
            )
        }
    }
}