package com.example.androidapp_lab2.ui.custom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is custom Fragment"
    }
    val text: LiveData<String> = _text
}