package com.example.testtaskansoft.feature.data.repository

import com.example.testtaskansoft.feature.data.database.DeliveryDao
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDeliveryRepositoryImpl(private val dao: DeliveryDao) : LocalDeliveryRepository {

    override fun getDeliveryByCompleted(isCompleted: Boolean): Flow<List<Delivery>> =
        dao.getDeliveryByCompleted(isCompleted).map { delivery -> delivery.map { it.toDelivery() } }

    override fun getAllDelivery(): Flow<List<Delivery>>  =
        dao.getAllDelivery().map { delivery -> delivery.map { it.toDelivery() } }

    override suspend fun completeDelivery(delivery: Delivery) {
        dao.update(delivery.toEntity())
    }

    override suspend fun clearLocalBd() {
        dao.clear()
    }

    override suspend fun insert(list: List<Delivery>) = dao.insert(list.map { it.toEntity() })
}