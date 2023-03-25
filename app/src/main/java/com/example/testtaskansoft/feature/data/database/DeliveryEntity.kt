package com.example.testtaskansoft.feature.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtaskansoft.feature.domain.model.Delivery

@Entity(tableName = "delivery")
class DeliveryEntity(
    @PrimaryKey
    val id: Int,
    val address: String,
    val lat: String,
    val lon: String,
    val phone: String,
    @ColumnInfo(name = "plan_time")
    val planTime: String,
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean,
) {
    fun toDelivery() = Delivery(address, id, lat, lon, phone, planTime, isCompleted)
}

