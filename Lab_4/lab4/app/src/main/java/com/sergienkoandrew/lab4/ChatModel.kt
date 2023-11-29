package com.sergienkoandrew.lab4

data class ChatModel (
    val id: Int,
    val avatar: Int,
    val name: String,
    val lastMessage: String,
    val lastMessageTime: String,
    val isRead: Boolean
)