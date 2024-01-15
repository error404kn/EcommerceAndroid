package com.example.itstepproject.data

sealed class Category(val category: String) {

    object Laptops: Category("Laptops")
    object Mouses: Category("Mouses")
    object MousePads: Category("MousePads")
    object Headsets: Category("Headsets")
    object Keyboards: Category("Keyboards")
    object Chairs: Category("Chairs")

}