package com.example.testtaskansoft.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskansoft.feature.data.state.LoadState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val _loadState = MutableStateFlow(LoadState.STARTED)
    val loadState = _loadState.asStateFlow()

    protected val handler = CoroutineExceptionHandler { _, throwable ->
        Log.e("Kart", "Coroutine Error =  ${throwable.message}")

        _loadState.value = LoadState.ERROR
    }

    fun workInViewModelScope(dispatcher: CoroutineDispatcher, block: suspend () -> Unit) {
        viewModelScope.launch(dispatcher + handler) {
            _loadState.value = LoadState.LOADING
            block()
            delay(500) // так как данные грузяться с базы данных прячим за лоодером удаление старых итемов
            _loadState.value = LoadState.SUCCESS
        }
    }
}