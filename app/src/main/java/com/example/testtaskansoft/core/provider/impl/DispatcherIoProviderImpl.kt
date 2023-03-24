package com.example.testtaskansoft.core.provider.impl

import com.example.testtaskansoft.core.provider.DispatcherIoProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherIoProviderImpl : DispatcherIoProvider {

    override val io: CoroutineDispatcher = Dispatchers.IO
}