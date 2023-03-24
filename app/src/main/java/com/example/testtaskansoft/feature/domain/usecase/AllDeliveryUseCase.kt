package com.example.testtaskansoft.feature.domain.usecase

import com.example.testtaskansoft.feature.domain.model.Delivery

interface AllDeliveryUseCase {

    suspend fun getAllDelivery():List<Delivery>

}