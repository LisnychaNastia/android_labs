package com.sergienkoandrew.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.sergienkoandrew.lab4.model.Chat
import com.sergienkoandrew.lab4.viewModel.ChatViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProvider(this)[ChatViewModel::class.java]

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ChatAdapter(emptyList())
        recyclerView.adapter = adapter

        val chatsObserver = Observer<List<Chat>>{
            chats -> adapter.update(chats)
        }
//        recyclerView.adapter = ChatAdapter(ChatStorage.random(this))

        findViewById<Button>(R.id.button).setOnClickListener {
            val chatName = findViewById<EditText>(R.id.editTextTextPersonName).getText().toString()
            if(chatName.isNotEmpty()){
                val chat = createChatObj(chatName)
                model.insertChat(chat)
            }
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            model.delAll()
        }
        model.chatsLiveData.observe(this, chatsObserver)
    }
    private fun createChatObj(chatName: String): Chat {
        val avatars = mutableListOf<Int>(
            R.drawable.avatar1,
            R.drawable.avatar2,
            R.drawable.avatar3,
            R.drawable.avatar4,
            R.drawable.avatar5,
            R.drawable.avatar6,
            R.drawable.avatar7,
            R.drawable.avatar8,
            R.drawable.avatar9,
            R.drawable.avatar10,
            R.drawable.avatar11,
            R.drawable.avatar12,
            R.drawable.avatar13,
            R.drawable.avatar14,
            R.drawable.avatar15
        )
        return Chat(
            0,
            name = chatName,
            avatarIndex = avatars[Random.nextInt(avatars.size)],
            lastMessage = "Hello, $chatName",
            lastMessageTime = "10:45 PM",
            isRead = Random.nextBoolean()
        )
    }
}