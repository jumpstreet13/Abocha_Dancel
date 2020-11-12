package com.abocha.quizapplication.java;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.abocha.quizapplication.kotlin.QuestionsModel;
import com.abocha.quizapplication.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizActivityJava extends AppCompatActivity {

    private QuizViewPagerAdapterJava quizViewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_layout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        Button button = findViewById(R.id.button);
        setTitle("Опрос");

        List<QuestionsModelJava> questionsModel = new ArrayList<>();

        questionsModel.add(
                new QuestionsModelJava(
                        "Кто кроме Тора поднимал молот",
                        Arrays.asList(
                                "Железный человек",
                                "Черная Вдова",
                                "Капитан Америка",
                                "Бэтмен"
                        ),
                        3
                )
        );

        questionsModel.add(
                new QuestionsModelJava(
                        "Кто умер во второй части мстителей ?",
                        Arrays.asList(
                                "Железный человек",
                                "Человек паук",
                                "Тор",
                                "Локи"
                        ),
                        1
                )
        );

        questionsModel.add(
                new QuestionsModelJava(
                        "Кого называют первым мстителем",
                        Arrays.asList(
                                "Халк",
                                "Вижн",
                                "Алая ведьма",
                                "Капитан Америка"
                        ),
                        4
                )
        );

        questionsModel.add(
                new QuestionsModelJava(
                        "Как звали супермена",
                        Arrays.asList(
                                "Абакар Магомедов",
                                "Данил Сербин",
                                "Дмитрий Григорьев",
                                "Кларк Кент"
                        ),
                        4
                )
        );

        questionsModel.add(
                new QuestionsModelJava(
                        "Чья это фраза - \"большая сила это большая ответственность\" ",
                        Arrays.asList(
                                "Дядя бен",
                                "Локи",
                                "Саске",
                                "Тор"
                        ),
                        1
                )
        );

        button.setOnClickListener(view -> {
            int count = 0;
            List<QuizFragmentJava> fragmentList = quizViewPagerAdapter.getFragments();
            for (QuizFragmentJava fragment : fragmentList) {
                if (fragment.getAnswer()) {
                    count++;
                }
            }
            startActivity(AnswerActivityJava.getIntent(QuizActivityJava.this, count));
        });

        List<QuizFragmentJava> quizFragments = new ArrayList<>();

        for (QuestionsModelJava model : questionsModel) {
            quizFragments.add(QuizFragmentJava.newInstance(model));
        }
        quizViewPagerAdapter = new QuizViewPagerAdapterJava(
                this,
                quizFragments
        );
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(quizViewPagerAdapter);
    }
}
