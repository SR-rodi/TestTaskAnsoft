package com.example.testtaskansoft.feature.presentation.delivery

import androidx.lifecycle.viewModelScope
import com.example.testtaskansoft.core.base.BaseViewModel
import com.example.testtaskansoft.core.provider.DispatcherIoProvider
import com.example.testtaskansoft.feature.data.state.LoadState
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.DataBaseClearDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.DataBaseGetDeliveryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

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

    val delivery: Flow<List<Delivery>> = dataBaseGetDeliveryUseCase.getDeliveryByCompleted(false)

    fun getDelivery() = workInViewModelScope(dispatcher.io) {
        clearDataBaseClearDeliveryUseCase.clearDatabase() // чистим базу каждый запуск
        allDeliveryUseCase.getAllDeliveryInDataBase()
    }

    fun setCompletedDelivery(deliveryItem: Delivery) =
        viewModelScope.launch(dispatcher.io + handler) {
            completeDeliveryUseCase.completeDelivery(deliveryItem.copy(isCompleted = true))
            delivery.collect { list -> if (list.isEmpty()) _loadState.value = LoadState.EMPTY }
        }

}