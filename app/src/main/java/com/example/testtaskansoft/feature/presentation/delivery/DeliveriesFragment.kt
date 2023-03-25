package com.example.testtaskansoft.feature.presentation.delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.testtaskansoft.R
import com.example.testtaskansoft.core.base.BaseFragment
import com.example.testtaskansoft.core.showError
import com.example.testtaskansoft.databinding.FragmentCompleteDeliveriesBinding
import com.example.testtaskansoft.feature.data.state.LoadState
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.presentation.adapter.DeliveryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeliveriesFragment : BaseFragment<FragmentCompleteDeliveriesBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentCompleteDeliveriesBinding.inflate(inflater)

    private val viewModel by viewModel<DeliveriesViewModel>()

    private val adapter by lazy { DeliveryAdapter(::clickItemListener) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        binding.textPlaceholder.text = resources.getText(R.string.placeholder_delivery)

        binding.recyclerView.itemAnimator = Animators()

        flowListener(viewModel.delivery) { delivery -> adapter.submitList(delivery) }

        flowListener(viewModel.loadState) { state -> loadStateListener(state) }

    }

    private fun loadStateListener(state: LoadState) {
        binding.placeholder.isVisible = state == LoadState.EMPTY
        binding.loading.isVisible = state == LoadState.LOADING
        if (state == LoadState.ERROR) showError { viewModel.getDelivery() }
    }

    private fun clickItemListener(deliveryItem: Delivery) {
        viewModel.setCompletedDelivery(deliveryItem)
    }

}