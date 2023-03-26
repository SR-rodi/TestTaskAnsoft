package com.example.testtaskansoft.feature.presentation.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.testtaskansoft.databinding.ItemDeliveryBinding
import com.example.testtaskansoft.feature.domain.model.Delivery

class DeliveryViewHolder(
    private val binding: ItemDeliveryBinding,
    private val onClickListener: (deliveryItem: Delivery) -> Unit,
) : BaseDeliveryHolder(binding) {

    private var delivery: Delivery? = null

    init {
        binding.deliveryButton.setOnClickListener {
            if (delivery != null) {
                onClickListener(delivery!!)
                binding.loading.isVisible = true
            }
        }
    }

    override fun bind(item: Delivery) {

        delivery = item

        binding.address.text = item.address
        binding.planTime.text = item.planTime
        binding.phone.text = item.phone
    }

    companion object {
        fun create(parent: ViewGroup, onClickListener: (deliveryItem: Delivery) -> Unit) =
            DeliveryViewHolder(
                ItemDeliveryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), onClickListener
            )
    }
}