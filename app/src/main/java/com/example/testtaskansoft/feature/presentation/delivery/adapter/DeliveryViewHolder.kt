package com.example.testtaskansoft.feature.presentation.delivery.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskansoft.databinding.ItemDeliveryBinding
import com.example.testtaskansoft.feature.domain.model.Delivery

class DeliveryViewHolder(
    private val binding: ItemDeliveryBinding,
    private val onClickListener: (deliveryItem: Delivery) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private var delivery: Delivery? = null

    init {
        binding.deliveryButton.setOnClickListener {
            if (delivery != null)
                onClickListener(delivery!!)
        }
    }

    fun bind(item: Delivery) {

        delivery = item

        binding.address.text = item.address
        binding.planTime.text = item.planTime
        binding.phone.text = item.phone
    }
}