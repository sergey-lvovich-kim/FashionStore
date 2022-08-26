package com.mikyegresl.fashionstore.presentation.features.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Menu Fragment"
    }
    val text: LiveData<String> = _text
}