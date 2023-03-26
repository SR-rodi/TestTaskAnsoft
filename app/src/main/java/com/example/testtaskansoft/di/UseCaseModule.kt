package com.example.testtaskansoft.di

import com.example.testtaskansoft.feature.domain.usecase.*
import com.example.testtaskansoft.feature.domain.usecase.impl.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {

    singleOf(::AllDeliveryUseCaseImpl) { bind<AllDeliveryUseCase>() }
    singleOf(::CompleteDeliveryUseCaseImpl) { bind<CompleteDeliveryUseCase>() }
    singleOf(::DataBaseGetDeliveryUseCaseImpl) { bind<DataBaseGetDeliveryUseCase>() }
    singleOf(::DataBaseClearDeliveryUseCaseImpl) { bind<DataBaseClearDeliveryUseCase>() }
    singleOf(::DataBaseAllDeliveryUseCaseImpl){bind<DataBaseAllDeliveryUseCase>()}
}