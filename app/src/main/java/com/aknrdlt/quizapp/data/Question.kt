package com.aknrdlt.quizapp.data

data class Question(
    val id: Long,
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: Int
)
