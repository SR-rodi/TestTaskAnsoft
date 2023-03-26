package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.DataBaseAllDeliveryUseCase
import kotlinx.coroutines.flow.Flow

class DataBaseAllDeliveryUseCaseImpl(
    private val repository: LocalDeliveryRepository
) : DataBaseAllDeliveryUseCase {

    override fun getAllDelivery(): Flow<List<Delivery>> =
        repository.getAllDelivery()
}