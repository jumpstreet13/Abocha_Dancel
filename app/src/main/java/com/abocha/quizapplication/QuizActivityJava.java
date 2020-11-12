package com.abocha.quizapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QuizActivityJava extends AppCompatActivity {

    private QuizViewPagerAdapter quizViewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_layout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        Button button = findViewById(R.id.button);
        setTitle("Опрос");

        List<QuestionsModel> questionsModel = new ArrayList<>();

        questionsModel.add(
                new QuestionsModel(
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
                new QuestionsModel(
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
                new QuestionsModel(
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
                new QuestionsModel(
                        "Как звали супермена",
                        Arrays.asList(
                                "Абакар Магомедов",
                                "Данил Серибин",
                                "Дмитрий Григорьев",
                                "Кларк Кент"
                        ),
                        4
                )
        );

        questionsModel.add(
                new QuestionsModel(
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
            List<QuizFragment> fragmentList = quizViewPagerAdapter.getFragments();
            for (QuizFragment fragment : fragmentList) {
                if (fragment.getAnswer()) {
                    count++;
                }
            }
            startActivity(AnswerActivityJava.getIntent(QuizActivityJava.this, count));
        });

        List<QuizFragment> quizFragments = new ArrayList<>();

        for (QuestionsModel model : questionsModel) {
            quizFragments.add(
                    QuizFragment.Companion.newInstance(model)
            );
        }
        quizViewPagerAdapter = new QuizViewPagerAdapter(
                this,
                quizFragments
        );
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(quizViewPagerAdapter);
    }
}
