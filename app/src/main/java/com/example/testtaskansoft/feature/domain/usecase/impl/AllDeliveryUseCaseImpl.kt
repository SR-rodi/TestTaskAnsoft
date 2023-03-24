package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.repository.DeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase

class AllDeliveryUseCaseImpl(private val repository: DeliveryRepository): AllDeliveryUseCase {

    override suspend fun getAllDelivery() = repository.getAllDelivery()
}