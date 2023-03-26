package com.example.testtaskansoft.feature.domain.repository

import com.example.testtaskansoft.feature.domain.model.Delivery
import kotlinx.coroutines.flow.Flow

interface LocalDeliveryRepository {

    fun getDeliveryByCompleted(isCompleted: Boolean): Flow<List<Delivery>>

    suspend fun completeDelivery(delivery: Delivery)

    suspend fun clearLocalBd()

    suspend fun insert(list: List<Delivery>)
}