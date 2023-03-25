package com.example.testtaskansoft.feature.presentation.maps

import androidx.lifecycle.ViewModel
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository

class MapsViewModel(repository: LocalDeliveryRepository) : ViewModel() {

    val completeDelivery = repository.getDeliveryByCompleted(false)

}