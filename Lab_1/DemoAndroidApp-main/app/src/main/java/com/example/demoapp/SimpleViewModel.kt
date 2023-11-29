package com.example.demoapp

import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    private var _str :String = ""
    val str : String
        get() = _str

    fun modifier(){
        _str = "updated demo text"
    }

}