package com.example.testtaskansoft.feature.domain.usecase

interface CompleteDeliveryUseCase {

    suspend fun completeDelivery(id: Int, lat: String, lon: String)
}