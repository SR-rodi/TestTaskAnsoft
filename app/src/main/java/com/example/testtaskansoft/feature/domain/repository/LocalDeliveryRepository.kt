package com.example.testtaskansoft.feature.domain.repository

import com.example.testtaskansoft.feature.domain.body.BodyComplete
import com.example.testtaskansoft.feature.domain.model.Delivery
import kotlinx.coroutines.flow.Flow

interface LocalDeliveryRepository {

    fun getAllDelivery(): Flow<Delivery>

    suspend fun completeDelivery(delivery: Delivery)

    suspend fun clearLocalBd()

    suspend fun insert(list:List<Delivery>):Int
}