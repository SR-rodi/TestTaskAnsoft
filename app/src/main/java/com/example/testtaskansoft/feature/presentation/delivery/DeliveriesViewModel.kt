package com.example.testtaskansoft.feature.presentation.delivery

import androidx.lifecycle.SavedStateHandle
import com.example.testtaskansoft.core.base.BaseViewModel
import com.example.testtaskansoft.core.provider.DispatcherIoProvider
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DeliveriesViewModel(
    private val allDeliveryUseCase: AllDeliveryUseCase,
    private val completeDeliveryUseCase: CompleteDeliveryUseCase,
    private val dispatcher: DispatcherIoProvider,
    private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    init {
        getDelivery()
    }

    protected val _delivery = MutableStateFlow(mapOf<Int, Delivery>())
    val delivery = _delivery.asStateFlow()


    fun getDelivery() = workInViewModelScope(dispatcher.io) {
        _delivery.value = allDeliveryUseCase.getAllDelivery()
        savedStateHandle[DELIVERY] = _delivery.value
    }

    fun setCompletedDelivery(id: Int, lat: String, lon: String) =
        workInViewModelScope(dispatcher.io) {
            completeDeliveryUseCase.completeDelivery(id, lat, lon)
            val oldList: MutableMap<Int, Delivery?> = _delivery.value.toMutableMap()
            oldList[id] = _delivery.value[id]
            savedStateHandle[DELIVERY] = oldList
        }

    companion object {
        const val DELIVERY = "Delivery"
    }

}