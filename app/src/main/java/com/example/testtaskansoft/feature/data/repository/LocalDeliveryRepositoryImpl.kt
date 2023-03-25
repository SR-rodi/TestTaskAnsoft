package com.example.testtaskansoft.feature.data.repository

import android.util.Log
import com.example.testtaskansoft.feature.data.database.DeliveryDao
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDeliveryRepositoryImpl(private val dao: DeliveryDao) : LocalDeliveryRepository {

    override fun getAllDelivery(): Flow<Delivery> =
        dao.getAll().map { delivery -> delivery.toDelivery() }

    override suspend fun completeDelivery(delivery: Delivery) {
        dao.update(delivery.toEntity())
    }

    override suspend fun clearLocalBd() {
        dao.clear()
    }

    override suspend fun insert(list: List<Delivery>): Int {
            val a = dao.insert(list.map { it.toEntity() })
            Log.e("Kart","test = $a")
        return 1
    }

}