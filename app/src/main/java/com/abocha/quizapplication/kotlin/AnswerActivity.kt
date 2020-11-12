package com.abocha.quizapplication.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.abocha.quizapplication.R.drawable
import com.abocha.quizapplication.R.id
import com.abocha.quizapplication.R.layout

class AnswerActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var rating: RatingBar
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_answer)
        title = "Ответ"

        imageView = findViewById(id.imageView)
        textView = findViewById(id.textView)
        rating = findViewById(id.ratingBar)

        when (val count = intent.getIntExtra(ANSWER_COUNT, 0)) {
            0 -> showAnswer(drawable.bw, "Вдова", count)
            1 -> showAnswer(drawable.h, "Соколиный глаз", count)
            2 -> showAnswer(drawable.halk, "Халк", count)
            3 -> showAnswer(drawable.thor, "Тор", count)
            4 -> showAnswer(drawable.cap, "Капитан Америка", count)
            5 -> showAnswer(drawable.im, "Железный человек", count)
        }
    }

    private fun showAnswer(imageRes: Int, text: String, count: Int) {
        rating.rating = count.toFloat()
        textView.text = text
        imageView.setImageResource(imageRes)
    }

    companion object {

        private const val ANSWER_COUNT = "ANSWER_COUNT"

        fun getIntent(context: Context, cont: Int): Intent =
            Intent(context, AnswerActivity::class.java).apply {
                putExtra(ANSWER_COUNT, cont)
            }
    }
}
