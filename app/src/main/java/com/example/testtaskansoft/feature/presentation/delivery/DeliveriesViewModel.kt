package com.example.testtaskansoft.feature.presentation.delivery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeliveriesViewModel(
    private val allDeliveryUseCase: AllDeliveryUseCase,
    private val completeDeliveryUseCase: CompleteDeliveryUseCase,
) : ViewModel() {


    fun getDelivery() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.e("KArt", allDeliveryUseCase.getAllDelivery().toString())
            } catch (e:Throwable){
                Log.e("KArt", e.toString())
            }


        }
    }

}