package com.example.testtaskansoft.feature.domain.usecase

import com.example.testtaskansoft.feature.domain.model.Delivery

interface CompleteDeliveryUseCase {

    suspend fun completeDelivery(deliveryItem: Delivery)
}