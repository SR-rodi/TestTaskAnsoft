package com.example.testtaskansoft.feature.presentation.delivery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testtaskansoft.databinding.ItemDeliveryBinding
import com.example.testtaskansoft.feature.domain.model.Delivery

class DeliveryAdapter(
    private val onClickListener: (deliveryItem: Delivery) -> Unit,
) : ListAdapter<Delivery, DeliveryViewHolder>(DeliveryDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DeliveryViewHolder(
        ItemDeliveryBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickListener
    )

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

