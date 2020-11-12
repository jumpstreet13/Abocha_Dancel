package com.abocha.quizapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class AnswerActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var rating: RatingBar
    private lateinit var textView: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        title = "Ответ"

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        rating = findViewById(R.id.ratingBar)

        count = intent.getIntExtra(ANSWER_COUNT, 0)
        when (count) {
            0 -> showAnswer(R.drawable.bw, "Вдова", count)
            1 -> showAnswer(R.drawable.h, "Соколиный глаз", count)
            2 -> showAnswer(R.drawable.halk, "Халк", count)
            3 -> showAnswer(R.drawable.thor, "Тор", count)
            4 -> showAnswer(R.drawable.cap, "Капитан Америка", count)
            5 -> showAnswer(R.drawable.im, "Железный человек", count)
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
