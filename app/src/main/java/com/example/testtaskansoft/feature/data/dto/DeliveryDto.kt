package com.example.testtaskansoft.feature.data.dto

import com.example.testtaskansoft.feature.domain.model.Delivery
import com.google.gson.annotations.SerializedName

class DeliveryDto(
    private val id: Int,
    private val lat: String,
    private val lon: String,
    private val phone: String,
    private val address: String,
    @SerializedName("plan_time")
    private val planTime: String,
) {
    fun toDelivery() = Delivery(address, id, lat, lon, phone, planTime)
}