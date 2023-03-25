package com.example.testtaskansoft.feature.domain.usecase

import com.example.testtaskansoft.feature.domain.model.Delivery
import kotlinx.coroutines.flow.Flow

interface DataBaseGetDeliveryUseCase {

   fun getDeliveryByCompleted(isCompleted:Boolean): Flow<List<Delivery>>
}