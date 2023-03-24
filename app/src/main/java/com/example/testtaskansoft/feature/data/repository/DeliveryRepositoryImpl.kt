package com.example.testtaskansoft.feature.data.repository

import com.example.testtaskansoft.feature.data.api.DeliveryApi
import com.example.testtaskansoft.feature.domain.body.BodyComplete
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.DeliveryRepository

class DeliveryRepositoryImpl(private val api: DeliveryApi) : DeliveryRepository {

    override suspend fun getAllDelivery() = api.getAllDelivery().map { dto -> dto.toDelivery() }

    override suspend fun completeDelivery(body: BodyComplete) {
        api.completeDelivery(body)
    }
}