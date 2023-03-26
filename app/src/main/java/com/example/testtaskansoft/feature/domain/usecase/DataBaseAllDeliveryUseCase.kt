package com.example.testtaskansoft.feature.domain.usecase

import com.example.testtaskansoft.feature.domain.model.Delivery
import kotlinx.coroutines.flow.Flow

interface DataBaseAllDeliveryUseCase {

    fun getAllDelivery(): Flow<List<Delivery>>
}