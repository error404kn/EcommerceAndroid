package com.example.itstepproject.data

data class CartProduct(
    val product: Product,
    val quantity: Int,
    val selectedColor: Int? = null,
){
    constructor(): this(Product(),1,null)
}
