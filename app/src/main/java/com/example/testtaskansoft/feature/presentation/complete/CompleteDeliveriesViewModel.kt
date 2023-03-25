package com.example.testtaskansoft.feature.presentation.complete

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CompleteDeliveriesViewModel (private val repository: LocalDeliveryRepository): ViewModel() {

  val a =  repository.getAllDelivery()

}