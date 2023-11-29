package com.sergienkoandrew.lab4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sergienkoandrew.lab4.model.Chat
import com.sergienkoandrew.lab4.model.ChatDao

@Database(entities = [Chat::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun chatDao(): ChatDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}