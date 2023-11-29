package com.sergienkoandrew.lab4.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChatDao {
    @Query("SELECT * FROM chat")
    suspend fun getAll(): List<Chat>

    @Insert
    suspend fun insertAll(vararg chats: Chat)

    @Delete
    suspend fun delete(chat: Chat)
}