package com.abocha.quizapplication.kotlin

import java.io.Serializable

class QuestionsModel(
    val question: String,
    val answers: List<String>,
    val answer: Int
) : Serializable
