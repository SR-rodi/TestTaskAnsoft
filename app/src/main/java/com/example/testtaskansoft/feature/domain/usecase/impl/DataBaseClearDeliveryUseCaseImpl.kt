package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.DataBaseClearDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.DataBaseGetDeliveryUseCase
import kotlinx.coroutines.flow.Flow

class DataBaseClearDeliveryUseCaseImpl(
    private val databaseRepository: LocalDeliveryRepository
    ):DataBaseClearDeliveryUseCase {

    override suspend fun clearDatabase() =databaseRepository.clearLocalBd()
}