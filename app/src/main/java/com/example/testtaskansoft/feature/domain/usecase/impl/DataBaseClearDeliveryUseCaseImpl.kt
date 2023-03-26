package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.DataBaseClearDeliveryUseCase

class DataBaseClearDeliveryUseCaseImpl(
    private val databaseRepository: LocalDeliveryRepository
) : DataBaseClearDeliveryUseCase {

    override suspend fun clearDatabase() = databaseRepository.clearLocalBd()
}