package com.example.learnnavigation.utils

var ItemList = mutableListOf<Items>()

data class Items(
    val date: String,
    val name: String,
    val quantity: Int,
    val price: Int
)