package com.example.testtaskansoft.feature.presentation.delivery

import com.example.testtaskansoft.core.base.BaseViewModel
import com.example.testtaskansoft.core.provider.DispatcherIoProvider
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.DataBaseClearDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.DataBaseGetDeliveryUseCase

class DeliveriesViewModel(
    private val allDeliveryUseCase: AllDeliveryUseCase,
    private val completeDeliveryUseCase: CompleteDeliveryUseCase,
    private val dispatcher: DispatcherIoProvider,
    private val clearDataBaseClearDeliveryUseCase: DataBaseClearDeliveryUseCase,
    dataBaseGetDeliveryUseCase: DataBaseGetDeliveryUseCase,
) : BaseViewModel() {

    init {
        getDelivery()
    }

    val delivery = dataBaseGetDeliveryUseCase.getDeliveryByCompleted(false)

    fun getDelivery() = workInViewModelScope(dispatcher.io) {
        clearDataBaseClearDeliveryUseCase.clearDatabase() // чистим базу каждый запуск
        allDeliveryUseCase.getAllDeliveryInDataBase()
    }

    fun setCompletedDelivery(deliveryItem: Delivery) =
        workInViewModelScope(dispatcher.io) {
            completeDeliveryUseCase.completeDelivery(deliveryItem.copy(isCompleted = true))
        }

}