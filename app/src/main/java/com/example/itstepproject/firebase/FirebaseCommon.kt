package com.example.itstepproject.firebase

import com.example.itstepproject.data.CartProduct
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.itstepproject.firebase.FirebaseCommon
import com.google.firebase.firestore.toObject
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject


class FirebaseCommon @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth,
){
    private val cartCollection = firestore.collection("user")
        .document(auth.uid!!).collection("cart")

    fun addProductToCart(cartProduct: CartProduct, onResult: (CartProduct?, Exception?) -> Unit){
        cartCollection.document().set(cartProduct).addOnSuccessListener {
            onResult(cartProduct, null)
        }.addOnFailureListener {
            onResult(null, it)
        }
    }

    fun increaseQuantity(documentId: String, onResult: (String?, Exception?) -> Unit){
        firestore.runTransaction{ transation ->
            val documentRef = cartCollection.document(documentId)
            val document = transation.get(documentRef)
            val productObject = document.toObject(CartProduct::class.java)
            productObject?.let {cartProduct ->
                val newQuantity = cartProduct.quantity + 1
                val newProductObject = cartProduct.copy(quantity = newQuantity)
                transation.set(documentRef, newProductObject)
            }
        }.addOnSuccessListener {
            onResult(documentId, null)
        }.addOnFailureListener {
            onResult(null, it)
        }
    }

    fun decreaseQuantity(documentId: String, onResult: (String?, Exception?) -> Unit){
        firestore.runTransaction{ transation ->
            val documentRef = cartCollection.document(documentId)
            val document = transation.get(documentRef)
            val productObject = document.toObject(CartProduct::class.java)
            productObject?.let {cartProduct ->
                val newQuantity = cartProduct.quantity - 1
                val newProductObject = cartProduct.copy(quantity = newQuantity)
                transation.set(documentRef, newProductObject)
            }
        }.addOnSuccessListener {
            onResult(documentId, null)
        }.addOnFailureListener {
            onResult(null, it)
        }
    }

    enum class QuantityChanging{
        INCREASE,DECREASE
    }



}