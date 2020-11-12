package com.abocha.quizapplication.kotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.abocha.quizapplication.R.id
import com.abocha.quizapplication.R.layout

class QuizActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var quizViewPagerAdapter: QuizViewPagerAdapter
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_quiz_layout)
        viewPager = findViewById(id.viewPager)
        button = findViewById(id.button)
        title = "Опрос"

        val questionModels = listOf(
            QuestionsModel(
                question = "Кто кроме Тора поднимал молот",
                answers = listOf(
                    "Железный человек",
                    "Черная Вдова",
                    "Капитан Америка",
                    "Бэтмен"
                ),
                answer = 3
            ),
            QuestionsModel(
                question = "Кто умер во второй части мстителей ?",
                answers = listOf(
                    "Железный человек",
                    "Человек паук",
                    "Тор",
                    "Локи"
                ),
                answer = 1
            ), QuestionsModel(
                question = "Кого называют первым мстителем",
                answers = listOf(
                    "Халк",
                    "Вижн",
                    "Алая ведьма",
                    "Капитан Америка"
                ),
                answer = 4
            ), QuestionsModel(
                question = "Как звали супермена",
                answers = listOf(
                    "Абакар Магомедов",
                    "Данил Сербин",
                    "Дмитрий Григорьев",
                    "Кларк Кент"
                ),
                answer = 4
            ), QuestionsModel(
                question = """Чья это фраза - "большая сила это большая ответственность" """,
                answers = listOf(
                    "Дядя бен",
                    "Локи",
                    "Саске",
                    "Тор"
                ),
                answer = 1
            )
        )

        button.setOnClickListener {
            var count = 0
            quizViewPagerAdapter.fragments.forEach {
                if (it.getAnswer()) {
                    count++
                }
            }
            startActivity(AnswerActivity.getIntent(this, count))
        }

        quizViewPagerAdapter = QuizViewPagerAdapter(
            activity = this,
            fragments = questionModels.map {
                QuizFragment.newInstance(
                    it
                )
            }
        )
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter = quizViewPagerAdapter
    }
}
