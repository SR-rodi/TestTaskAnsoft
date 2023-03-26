package com.example.testtaskansoft.feature.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDao {

    @Query("SELECT * FROM delivery WHERE is_completed = :isCompleted")
    fun getDeliveryByCompleted(isCompleted: Boolean): Flow<List<DeliveryEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(list: List<DeliveryEntity>)

    @Update
    fun update(deliveryEntity: DeliveryEntity)

    @Query("DELETE FROM delivery")
    fun clear()
}
