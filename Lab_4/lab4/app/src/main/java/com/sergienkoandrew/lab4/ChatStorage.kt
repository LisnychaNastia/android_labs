package com.sergienkoandrew.lab4

import android.content.Context
import kotlin.random.Random

object ChatStorage {
    private val avatars = mutableListOf<Int>(
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
    fun random(context: Context) = MutableList(100) {
        ChatModel(
            it,
            avatars[Random.nextInt(avatars.size)],
            DummyNameStorage.random(),
            "Hello, Peter",
            "10:45 PM",
            Random.nextBoolean()
        )
    }
}