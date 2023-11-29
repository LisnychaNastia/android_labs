package com.sergienkoandrew.lab4.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Chat(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="avatar_index") val avatarIndex: Int?,
    @ColumnInfo(name="last_message") val lastMessage: String?,
    @ColumnInfo(name="last_message_time") val lastMessageTime: String?,
    @ColumnInfo(name="is_read") val isRead: Boolean
)