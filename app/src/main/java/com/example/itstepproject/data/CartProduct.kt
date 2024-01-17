package com.example.itstepproject.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartProduct(
    val product: Product,
    val quantity: Int,
    val selectedColor: Int? = null,
): Parcelable{
    constructor(): this(Product(),1,null)
}
