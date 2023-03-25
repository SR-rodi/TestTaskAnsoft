package com.example.testtaskansoft.feature.presentation.delivery.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testtaskansoft.feature.domain.model.Delivery

class DeliveryDiffUtil : DiffUtil.ItemCallback<Delivery>() {
    override fun areItemsTheSame(oldItem: Delivery, newItem: Delivery) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Delivery, newItem: Delivery) = oldItem == newItem

}