package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.DataBaseGetDeliveryUseCase

class DataBaseGetDeliveryUseCaseImpl(
    private val databaseRepository: LocalDeliveryRepository,
) : DataBaseGetDeliveryUseCase {

    override fun getDeliveryByCompleted(isCompleted: Boolean) =
        databaseRepository.getDeliveryByCompleted(isCompleted)
}