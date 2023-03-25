package com.example.testtaskansoft.feature.domain.model

import com.example.testtaskansoft.feature.data.database.DeliveryEntity
import com.example.testtaskansoft.feature.domain.body.BodyComplete

data class Delivery(
    val address: String,
    val id: Int,
    val lat: String,
    val lon: String,
    val phone: String,
    val planTime: String,
    var isCompleted: Boolean = false,
) {
    fun toEntity() = DeliveryEntity(id, address, lat, lon, phone, planTime, isCompleted)

    fun toBody() = BodyComplete(id)

}