package com.example.testtaskansoft.feature.presentation.complete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.databinding.FragmentCompleteDeliveriesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompleteDeliveriesFragment : BaseFragment<FragmentCompleteDeliveriesBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentCompleteDeliveriesBinding.inflate(inflater)

    private val viewModel by viewModel<CompleteDeliveriesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel
        // viewModel.getDelivery()
    }
}