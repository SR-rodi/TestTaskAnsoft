package com.example.testtaskansoft.feature.presentation.complete

import androidx.lifecycle.ViewModel
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository

class CompleteDeliveriesViewModel (private val repository: LocalDeliveryRepository): ViewModel() {

  val completeDelivery =  repository.getDeliveryByCompleted(true)

}