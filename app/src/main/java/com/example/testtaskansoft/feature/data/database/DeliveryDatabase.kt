package com.example.testtaskansoft.feature.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        DeliveryEntity::class
    ], version = 1
)
abstract class DeliveryDatabase : RoomDatabase() {

    abstract fun deliveryDao(): DeliveryDao
}