package com.example.testtaskansoft.feature.presentation.delivery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testtaskansoft.databinding.ItemDeliveryBinding
import com.example.testtaskansoft.feature.domain.model.Delivery

class DeliveryAdapter : ListAdapter<Delivery, DeliveryViewHolder>(DeliveryDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DeliveryViewHolder(
        ItemDeliveryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DeliveryDiffUtil : DiffUtil.ItemCallback<Delivery>() {
    override fun areItemsTheSame(oldItem: Delivery, newItem: Delivery) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Delivery, newItem: Delivery) = oldItem == newItem

}

class DeliveryViewHolder(private val binding: ItemDeliveryBinding) : ViewHolder(binding.root) {

    fun bind(item: Delivery) {

        binding.address.text = item.address
        binding.planTime.text = item.planTime
        binding.phone.text = item.phone
    }
}

