package com.example.learnnavigation.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnnavigation.utils.Items
import com.example.learnnavigation.utils.ResourceState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AddItemFragmentViewModel :ViewModel() {

    private var _isValid = MutableLiveData<ResourceState>()
    val isValid : LiveData<ResourceState>
    get() {
        return _isValid
    }

    fun inputValidation(items:Items) {
        GlobalScope.launch {
            //kalo gapake global scope langsung _isvalid.value
            _isValid.postValue(ResourceState.loading())
            delay(2000)

            if(items.date.isNullOrBlank()) {
                _isValid.postValue(ResourceState.fail("Date cannot be null"))
            } else if(items.name.isNullOrBlank()) {
                _isValid.postValue(ResourceState.fail("name cannot be null"))
            } else if (items.quantity.toString().isNullOrBlank()) {
                _isValid.postValue(ResourceState.fail("quantity cannot be null"))
            } else if(items.price.toString().isNullOrBlank()) {
                _isValid.postValue(ResourceState.fail("price cannot be null"))
            } else {
                _isValid.postValue(ResourceState.success(true))
            }
        }
    }

}