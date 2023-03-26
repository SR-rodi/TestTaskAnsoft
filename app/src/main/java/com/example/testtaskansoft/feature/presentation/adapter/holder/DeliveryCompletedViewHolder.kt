package com.example.testtaskansoft.feature.presentation.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.testtaskansoft.databinding.ItemCompletedDeliveryBinding
import com.example.testtaskansoft.feature.domain.model.Delivery

class DeliveryCompletedViewHolder(
    private val binding: ItemCompletedDeliveryBinding,
) : BaseDeliveryHolder(binding) {


    override fun bind(item: Delivery) {
        binding.address.text = item.address
        binding.phone.text = item.phone
    }

    companion object {

        fun create(parent: ViewGroup) =
            DeliveryCompletedViewHolder(
                ItemCompletedDeliveryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
    }
}