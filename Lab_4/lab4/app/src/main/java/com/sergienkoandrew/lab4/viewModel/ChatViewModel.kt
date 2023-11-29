package com.sergienkoandrew.lab4.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sergienkoandrew.lab4.AppDatabase
import com.sergienkoandrew.lab4.model.Chat
import kotlinx.coroutines.launch

class ChatViewModel(application: Application): AndroidViewModel(application) {
    private val chatDb = AppDatabase.getInstance(application).chatDao()

    private val _chatsLiveData = MutableLiveData<List<Chat>>()
    val chatsLiveData: LiveData<List<Chat>> = _chatsLiveData

    init {
        viewModelScope.launch {
            loadChats()
        }
    }

    fun insertChat(chat: Chat){
        viewModelScope.launch{
            chatDb.insertAll(chat)
            loadChats()
        }
    }

    private suspend fun loadChats(){
        _chatsLiveData.value = chatDb.getAll()
    }

    fun delAll(){
        viewModelScope.launch {
            for(chat in chatsLiveData.value!!){
                chatDb.delete(chat)
            }
            loadChats()
        }
    }
}