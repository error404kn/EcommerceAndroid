package com.example.itstepproject.viewmodel.factory

import androidx.lifecycle.ViewModelProvider
import com.example.itstepproject.data.Category
import com.example.itstepproject.viewmodel.CategoryViewModel
import com.google.firebase.firestore.FirebaseFirestore

class BaseCategoryViewModelFactory(
    private val firestore: FirebaseFirestore,
    private val category: Category
): ViewModelProvider.Factory{
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: java.lang.Class<T>): T {
        return CategoryViewModel(firestore, category) as T
    }
}