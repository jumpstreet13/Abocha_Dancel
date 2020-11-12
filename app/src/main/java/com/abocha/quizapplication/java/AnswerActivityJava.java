package com.abocha.quizapplication.java;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.abocha.quizapplication.R;
import com.abocha.quizapplication.kotlin.AnswerActivity;

public class AnswerActivityJava extends AppCompatActivity {

    private ImageView imageView;
    private RatingBar rating;
    private TextView textView;
    private static final String ANSWER_COUNT = "ANSWER_COUNT";

    public static Intent getIntent(Context context, int cont) {
        return new Intent(context, AnswerActivity.class).putExtra(ANSWER_COUNT, cont);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_answer);
        setTitle("Ответ");

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        rating = findViewById(R.id.ratingBar);

        int count = getIntent().getIntExtra(ANSWER_COUNT, 0);
        switch (count) {
            case 0: {
                showAnswer(R.drawable.bw, "Вдова", count);
                break;
            }
            case 1: {
                showAnswer(R.drawable.h, "Соколиный глаз", count);
                break;
            }
            case 2: {
                showAnswer(R.drawable.halk, "Халк", count);
                break;
            }
            case 3: {
                showAnswer(R.drawable.thor, "Тор", count);
                break;
            }
            case 4: {
                showAnswer(R.drawable.cap, "Капитан Америка", count);
                break;
            }
            case 5: {
                showAnswer(R.drawable.im, "Железный человек", count);
                break;
            }
        }
    }

    private void showAnswer(int imageRes, String text, int count) {
        rating.setRating(count);
        textView.setText(text);
        imageView.setImageResource(imageRes);
    }
}
