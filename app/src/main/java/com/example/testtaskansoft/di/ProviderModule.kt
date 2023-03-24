package com.example.testtaskansoft.di

import com.example.testtaskansoft.core.provider.DispatcherIoProvider
import com.example.testtaskansoft.core.provider.impl.DispatcherIoProviderImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val providerModule = module {

    singleOf(::DispatcherIoProviderImpl){bind<DispatcherIoProvider>()}
}