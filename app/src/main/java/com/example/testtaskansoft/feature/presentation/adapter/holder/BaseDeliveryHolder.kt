package com.example.testtaskansoft.feature.presentation.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.testtaskansoft.feature.domain.model.Delivery

abstract class BaseDeliveryHolder(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root){
   abstract fun bind(item: Delivery)

}