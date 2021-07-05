package com.aknrdlt.quizapp.data

import android.content.res.Resources
import com.aknrdlt.quizapp.R
import com.aknrdlt.quizapp.data.Question

object Questions {
    fun questionsList(): List<Question> {
        return listOf(
            Question(
                id = 1,
                question = "Sheep, Lord of the rings, rugby",
                optionA = "Australia",
                optionB = "New Zealand",
                optionC = "Scotland",
                optionD = "Sweden",
                correctAnswer = "New Zealand"
            ),
            Question(
                id = 2,
                question = "Syrup, moose, hockey",
                optionA = "Cuba",
                optionB = "Turkey",
                optionC = "US",
                optionD = "Canada",
                correctAnswer = "Canada"
            ),
            Question(
                id = 3,
                question = "Louvre, macarons, romance",
                optionA = "Mexico",
                optionB = "Australia",
                optionC = "Malaysia",
                optionD = "France",
                correctAnswer = "France"
            ),
            Question(
                id = 4,
                question = "Chocolate, Red Devils, football",
                optionA = "Morocco",
                optionB = "Afghanistan",
                optionC = "Thailand",
                optionD = "Belgium",
                correctAnswer = "Belgium"
            ),
            Question(
                id = 5,
                question = "Vodka, Hermitage, cold",
                optionA = "Iceland",
                optionB = "Greenland",
                optionC = "Brazil",
                optionD = "Russia",
                correctAnswer = "Russia"
            ),
            Question(
                id = 6,
                question = "Pyramids, hot weather, Sahara Desert",
                optionA = "Turkey",
                optionB = "Pakistan",
                optionC = "Malaysia",
                optionD = "Egypt",
                correctAnswer = "Egypt"
            ),
            Question(
                id = 7,
                question = "Colosseum, Rome, Venice",
                optionA = "Yemen",
                optionB = "Algeria",
                optionC = "Australia",
                optionD = "Italy",
                correctAnswer = "Italy"
            ),
            Question(
                id = 8,
                question = "Hollywood, Grand Canyon, NASA",
                optionA = "US",
                optionB = "Canada",
                optionC = "Barbados",
                optionD = "Brazil",
                correctAnswer = "US"
            ),
            Question(
                id = 9,
                question = "Big Ben, Buckingham palace, black pudding",
                optionA = "Austrailia",
                optionB = "Yemen",
                optionC = "England",
                optionD = "New Zealand",
                correctAnswer = "England"
            )
        )
    }
}