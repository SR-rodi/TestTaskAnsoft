package com.example.testtaskansoft.feature.presentation.complete

import androidx.lifecycle.ViewModel
import com.example.testtaskansoft.feature.domain.usecase.DataBaseGetDeliveryUseCase

class CompleteDeliveriesViewModel(deliveryUSeCase: DataBaseGetDeliveryUseCase) : ViewModel() {

    val completeDelivery = deliveryUSeCase.getDeliveryByCompleted(true)

}