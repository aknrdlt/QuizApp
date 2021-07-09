package com.aknrdlt.quizapp

import android.content.res.Resources
import com.aknrdlt.quizapp.data.User

object Users {
    fun usersList(): MutableList<User> {
        return mutableListOf(
            User(
                id = 1,
                name = "Brad",
                score = 7
            ),
            User(
                id = 2,
                name = "John",
                score = 6
            )
        )
    }
}
