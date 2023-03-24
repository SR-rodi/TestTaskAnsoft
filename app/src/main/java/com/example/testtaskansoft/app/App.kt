package com.example.testtaskansoft.app

import android.app.Application
import com.example.testtaskansoft.di.*
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    networkModule,
                    useCaseModule,
                    providerModule
                )
            )
        }
    }
}