package com.aknrdlt.quizapp

import android.content.res.Resources
import com.aknrdlt.quizapp.data.User

/* Returns initial list of flowers. */
fun flowerList(resources: Resources): List<User> {
    return listOf(
        User(
            id = 1,
            name = resources.getString(R.string.name_1),
            score = 7
        ),
        User(
            id = 2,
            name = resources.getString(R.string.name_2),
            score = 6
        ),

    )
}
