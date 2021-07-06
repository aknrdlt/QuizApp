package com.aknrdlt.quizapp

import android.content.res.Resources
import com.aknrdlt.quizapp.data.User

object Users {
    fun usersList(): MutableList<User> {
        return mutableListOf(
            User(
                id = 1,
                name = "Akooo",
                score = 7
            ),
            User(
                id = 2,
                name = "Zhakoo",
                score = 6
            ),
        )
    }
}
