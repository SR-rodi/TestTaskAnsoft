package com.example.testtaskansoft.feature.presentation.delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.databinding.FragmentCompleteDeliveriesBinding
import com.example.testtaskansoft.feature.presentation.delivery.adapter.DeliveryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeliveriesFragment : BaseFragment<FragmentCompleteDeliveriesBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentCompleteDeliveriesBinding.inflate(inflater)

    private val viewModel by viewModel<DeliveriesViewModel>()

    private val adapter by lazy { DeliveryAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDelivery()

        binding.recyclerView.adapter = adapter

        flowListener(viewModel.delivery) { mapDelivery ->
            adapter.submitList(mapDelivery.values.toList())
        }

    }

}