package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.body.BodyComplete
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import com.example.testtaskansoft.feature.domain.repository.NetworkDeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase

class CompleteDeliveryUseCaseImpl(
    private val networkRepository: NetworkDeliveryRepository,
    private val localRepository: LocalDeliveryRepository,
) : CompleteDeliveryUseCase {

    override suspend fun completeDelivery(deliveryItem: Delivery) {
        networkRepository.completeDelivery(deliveryItem.toBody())
        localRepository.completeDelivery(deliveryItem)

    }
}