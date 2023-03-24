package com.example.testtaskansoft.feature.domain.usecase.impl

import com.example.testtaskansoft.feature.domain.body.BodyComplete
import com.example.testtaskansoft.feature.domain.repository.DeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase

class CompleteDeliveryUseCaseImpl(private val repository: DeliveryRepository):
    CompleteDeliveryUseCase {

    override suspend fun completeDelivery(id: Int, lat: String, lon: String) =
        repository.completeDelivery(BodyComplete(id,lat,lon))
}