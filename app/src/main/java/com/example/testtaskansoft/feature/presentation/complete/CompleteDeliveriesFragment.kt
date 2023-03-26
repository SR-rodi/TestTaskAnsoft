package com.example.testtaskansoft.feature.presentation.complete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.example.testtaskansoft.R
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.databinding.FragmentCompleteDeliveriesBinding
import com.example.testtaskansoft.feature.presentation.adapter.DeliveryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompleteDeliveriesFragment : BaseFragment<FragmentCompleteDeliveriesBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentCompleteDeliveriesBinding.inflate(inflater)

    private val viewModel by viewModel<CompleteDeliveriesViewModel>()

    private val adapter by lazy { DeliveryAdapter {} }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textPlaceholder.text = resources.getText(R.string.placeholder_compete_delivery)

        binding.recyclerView.adapter = adapter
        flowListener(viewModel.completeDelivery) { listDelivery ->
            adapter.submitList(listDelivery)
            binding.placeholder.isVisible = listDelivery.isEmpty()
        }
    }
}