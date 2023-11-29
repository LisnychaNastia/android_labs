package com.example.androidapp_lab2.ui.change

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChangeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is change Fragment"
    }
    val text: LiveData<String> = _text
}