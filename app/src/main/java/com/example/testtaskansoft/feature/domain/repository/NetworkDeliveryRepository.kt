package com.example.testtaskansoft.feature.domain.repository

import com.example.testtaskansoft.feature.domain.body.BodyComplete
import com.example.testtaskansoft.feature.domain.model.Delivery

interface NetworkDeliveryRepository {

    suspend fun getAllDelivery(): List<Delivery>

    suspend fun completeDelivery(body: BodyComplete)

}