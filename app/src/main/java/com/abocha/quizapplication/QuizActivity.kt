package com.abocha.quizapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class QuizActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var quizViewPagerAdapter: QuizViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_layout)
        viewPager = findViewById(R.id.viewPager)
        title = "Опрос"

        val questionModels = listOf(
            QuestionsModel(
                question = "Почему вы такой еблан",
                answers = listOf(
                    "Хуй его знает",
                    "Завали ебало",
                    "Потому что я айосник",
                    "Потому что я на бутылке"
                ),
                answer = 4
            ),
            QuestionsModel(
                question = "Почему вы такой еблан",
                answers = listOf(
                    "Хуй его знает",
                    "Завали ебало",
                    "Потому что я айосник",
                    "Потому что я на бутылке"
                ),
                answer = 4
            ), QuestionsModel(
                question = "Почему вы такой еблан",
                answers = listOf(
                    "Хуй его знает",
                    "Завали ебало",
                    "Потому что я айосник",
                    "Потому что я на бутылке"
                ),
                answer = 4
            ), QuestionsModel(
                question = "Почему вы такой еблан",
                answers = listOf(
                    "Хуй его знает",
                    "Завали ебало",
                    "Потому что я айосник",
                    "Потому что я на бутылке"
                ),
                answer = 4
            ), QuestionsModel(
                question = "Почему вы такой еблан",
                answers = listOf(
                    "Хуй его знает",
                    "Завали ебало",
                    "Потому что я айосник",
                    "Потому что я на бутылке"
                ),
                answer = 4
            ),
            QuestionsModel(
                question = "Почему вы такой еблан",
                answers = listOf(
                    "Хуй его знает",
                    "Завали ебало",
                    "Потому что я айосник",
                    "Потому что я на бутылке"
                ),
                answer = 4
            )
        )

        quizViewPagerAdapter = QuizViewPagerAdapter(
            activity = this,
            questionsModels = questionModels
        )
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter = quizViewPagerAdapter
    }
}
