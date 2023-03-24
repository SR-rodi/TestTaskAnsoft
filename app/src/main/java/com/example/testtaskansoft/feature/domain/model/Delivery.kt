package com.example.testtaskansoft.feature.domain.model

data class Delivery(
    val address: String,
    val id: Int,
    val lat: String,
    val lon: String,
    val phone: String,
    val planTime: String
)