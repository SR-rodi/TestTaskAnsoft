package com.example.testtaskansoft.di

import com.example.testtaskansoft.feature.presentation.complete.CompleteDeliveriesViewModel
import com.example.testtaskansoft.feature.presentation.delivery.DeliveriesViewModel
import com.example.testtaskansoft.feature.presentation.maps.MapsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

      viewModelOf(::CompleteDeliveriesViewModel)
   // viewModel { (CompleteDeliveriesViewModel(get())) }
    viewModelOf(::MapsViewModel)
    viewModelOf(::DeliveriesViewModel)
}