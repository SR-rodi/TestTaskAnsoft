package com.example.testtaskansoft.feature.data.repository

import com.example.testtaskansoft.feature.data.api.DeliveryApi
import com.example.testtaskansoft.feature.domain.body.BodyComplete
import com.example.testtaskansoft.feature.domain.repository.NetworkDeliveryRepository

class NetworkDeliveryRepositoryImpl(private val api: DeliveryApi) : NetworkDeliveryRepository {

    override suspend fun getAllDelivery() =
        api.getAllDelivery().map { dto -> dto.toDelivery() }

    override suspend fun completeDelivery(body: BodyComplete) {
        api.completeDelivery(body)
    }
}