package com.example.testtaskansoft.feature.presentation.delivery.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskansoft.databinding.ItemDeliveryBinding
import com.example.testtaskansoft.feature.domain.model.Delivery

class DeliveryViewHolder(
    private val binding: ItemDeliveryBinding,
    private val onClickListener: (id: Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private var delivery: Delivery? = null

    init {
        binding.deliveryButton.setOnClickListener {
            onClickListener(adapterPosition)
        }
    }

    fun bind(item: Delivery) {

        delivery = item

        binding.address.text = item.address
        binding.planTime.text = item.planTime
        binding.phone.text = item.phone
    }
}