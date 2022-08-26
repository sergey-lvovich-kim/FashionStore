package com.mikyegresl.fashionstore.presentation.features.bag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BagViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Bag Fragment"
    }
    val text: LiveData<String> = _text
}