package com.example.testtaskansoft.di

import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.DataBaseClearDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.DataBaseGetDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.impl.AllDeliveryUseCaseImpl
import com.example.testtaskansoft.feature.domain.usecase.impl.CompleteDeliveryUseCaseImpl
import com.example.testtaskansoft.feature.domain.usecase.impl.DataBaseClearDeliveryUseCaseImpl
import com.example.testtaskansoft.feature.domain.usecase.impl.DataBaseGetDeliveryUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {

    singleOf(::AllDeliveryUseCaseImpl) { bind<AllDeliveryUseCase>() }
    singleOf(::CompleteDeliveryUseCaseImpl) { bind<CompleteDeliveryUseCase>() }
    singleOf(::DataBaseGetDeliveryUseCaseImpl) { bind<DataBaseGetDeliveryUseCase>() }
    singleOf(::DataBaseClearDeliveryUseCaseImpl) { bind<DataBaseClearDeliveryUseCase>() }
}