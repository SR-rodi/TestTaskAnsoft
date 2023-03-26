package com.example.testtaskansoft.di

import com.example.testtaskansoft.core.provider.DispatcherIoProvider
import com.example.testtaskansoft.core.provider.FusedClientProvider
import com.example.testtaskansoft.core.provider.LocationManagerProvider
import com.example.testtaskansoft.core.provider.impl.DispatcherIoProviderImpl
import com.example.testtaskansoft.core.provider.impl.FusedClientProviderImpl
import com.example.testtaskansoft.core.provider.impl.LocationManagerProviderImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val providerModule = module {

    singleOf(::DispatcherIoProviderImpl) { bind<DispatcherIoProvider>() }
    singleOf(::LocationManagerProviderImpl){bind<LocationManagerProvider>()}
    singleOf(::FusedClientProviderImpl){bind<FusedClientProvider>()}

}