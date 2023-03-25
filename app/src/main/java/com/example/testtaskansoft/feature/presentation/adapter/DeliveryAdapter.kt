package com.example.testtaskansoft.feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testtaskansoft.R
import com.example.testtaskansoft.databinding.ItemCompletedDeliveryBinding
import com.example.testtaskansoft.databinding.ItemDeliveryBinding
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.presentation.adapter.holder.BaseDeliveryHolder
import com.example.testtaskansoft.feature.presentation.adapter.holder.DeliveryCompletedViewHolder
import com.example.testtaskansoft.feature.presentation.adapter.holder.DeliveryViewHolder

class DeliveryAdapter(
    private val onClickListener: (deliveryItem: Delivery) -> Unit,
) : ListAdapter<Delivery, BaseDeliveryHolder>(DeliveryDiffUtil()) {

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).isCompleted) COMPLETE_DELIVERY_ID else DELIVERY_ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseDeliveryHolder {
        return when (viewType) {
            DELIVERY_ID -> DeliveryViewHolder(
                ItemDeliveryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), onClickListener
            )
            COMPLETE_DELIVERY_ID -> DeliveryCompletedViewHolder(
                ItemCompletedDeliveryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else->throw ExceptionInInitializerError("Error create ViewHolder. No ViewType")
        }
    }

    override fun onBindViewHolder(holder: BaseDeliveryHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private const val DELIVERY_ID = R.layout.item_delivery
        private const val COMPLETE_DELIVERY_ID = R.layout.item_completed_delivery
    }
}

