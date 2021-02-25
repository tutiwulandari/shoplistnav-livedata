package com.example.learnnavigation.models

import androidx.lifecycle.ViewModel
import com.example.learnnavigation.utils.ItemList
import com.example.learnnavigation.utils.Items

class ItemViewModel: ViewModel() {

    fun addItem(items: Items) {
        ItemList.add(items)
    }

    fun getItem():MutableList<Items>{
        return ItemList
    }

}