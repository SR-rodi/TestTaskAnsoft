package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import com.example.testtaskansoft.feature.domain.repository.NetworkDeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase

class AllDeliveryUseCaseImpl(
    private val networkRepository: NetworkDeliveryRepository,
    private val localRepository: LocalDeliveryRepository,

    ) : AllDeliveryUseCase {

    override suspend fun getAllDeliveryInDataBase(): List<Delivery> {
        val list = networkRepository.getAllDelivery()
        localRepository.insert(list)
        return list
    }
}