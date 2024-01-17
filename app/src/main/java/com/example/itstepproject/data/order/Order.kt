package com.example.itstepproject.data.order

import com.example.itstepproject.data.Address
import com.example.itstepproject.data.CartProduct

data class Order(
    val orderStatus: String,
    val totalPrice: Float,
    val products: List<CartProduct>,
    val address: Address
)
