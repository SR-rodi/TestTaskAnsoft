package com.example.testtaskansoft.core.provider

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherIoProvider {

    val io: CoroutineDispatcher
}