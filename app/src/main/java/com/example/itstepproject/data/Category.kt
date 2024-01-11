package com.example.itstepproject.data

sealed class Category(val category: String) {

    object Laptops: Category("ლეპტოპები")
    object Mouses: Category("მაუსები")
    object MousePads: Category("მაუს პედები")
    object Headsets: Category("ყურსასმენები")
    object Keyboards: Category("კლავიატურები")
    object Chairs: Category("სავარძლები")

}