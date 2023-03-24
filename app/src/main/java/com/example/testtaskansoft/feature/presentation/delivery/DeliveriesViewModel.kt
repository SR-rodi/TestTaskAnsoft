package com.example.testtaskansoft.feature.presentation.delivery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskansoft.core.provider.DispatcherIoProvider
import com.example.testtaskansoft.feature.data.api.DeliveryApi
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeliveriesViewModel(
    private val allDeliveryUseCase: AllDeliveryUseCase,
    private val completeDeliveryUseCase: CompleteDeliveryUseCase,
    private val api:DeliveryApi
) : ViewModel() {


    fun getDelivery() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.e("KArt", api.getAllDelivery().toString())
            } catch (e:Throwable){
                Log.e("KArt", e.toString())
            }


        }
    }

}