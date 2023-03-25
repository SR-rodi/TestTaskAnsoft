package com.example.testtaskansoft.feature.presentation.delivery

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
) : BaseViewModel() {

    init {
        getDelivery()
    }

    protected val _delivery = MutableStateFlow(listOf<Delivery>())
    val delivery = _delivery.asStateFlow()


    fun getDelivery() = workInViewModelScope(dispatcher.io) {
        _delivery.value = allDeliveryUseCase.getAllDelivery()
    }

    fun setCompletedDelivery(position: Int) =
        workInViewModelScope(dispatcher.io) {
            val listDelivery = delivery.value.toMutableList()
            val deliveryItem = listDelivery[position]
            //completeDeliveryUseCase.completeDelivery(deliveryItem.toBody())
            listDelivery.removeAt(position)
            _delivery.value = listDelivery
        }

}