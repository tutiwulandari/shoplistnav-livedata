package com.example.learnnavigation.models

import androidx.lifecycle.ViewModel
import com.example.learnnavigation.utils.Items

class ItemViewModel: ViewModel() {

    private var ItemList = mutableListOf<Items>()

    fun addItem(items: Items) {
        ItemList.add(items)
    }

    fun getItem():MutableList<Items>{
        return ItemList
    }

}