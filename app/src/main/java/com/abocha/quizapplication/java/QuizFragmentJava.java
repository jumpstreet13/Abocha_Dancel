package com.abocha.quizapplication.java;

import static com.abocha.quizapplication.kotlin.QuizFragmentKt.QUESTIONS_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.abocha.quizapplication.kotlin.QuestionsModel;
import com.abocha.quizapplication.R;
import java.util.List;

public class QuizFragmentJava extends Fragment {

    private static String QUESTIONS_KEY = "QUESTIONS_KEY";

    private RadioButton firstQuestion;
    private RadioButton secondQuestion;
    private RadioButton thirdQuestion;
    private RadioButton fourthQuestion;
    private TextView question;
    private QuestionsModelJava questionsModel;
    private RadioGroup radioGroup;

    public static QuizFragmentJava newInstance(QuestionsModelJava questionsModel) {
        QuizFragmentJava fragment = new QuizFragmentJava();
        Bundle bundle = new Bundle();
        bundle.putSerializable(QUESTIONS_KEY, questionsModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionsModel = (QuestionsModelJava) getArguments().getSerializable(QUESTIONS_KEY);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_quiz_layout, container, false);
        firstQuestion = view.findViewById(R.id.firstOption);
        secondQuestion = view.findViewById(R.id.secondOption);
        thirdQuestion = view.findViewById(R.id.thirdOption);
        fourthQuestion = view.findViewById(R.id.fourthOption);
        radioGroup = view.findViewById(R.id.radioGroup);
        question = view.findViewById(R.id.question);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> answers = questionsModel.getAnswers();

        question.setText(questionsModel.getQuestion());
        firstQuestion.setText(answers.get(0));
        secondQuestion.setText(answers.get(1));
        thirdQuestion.setText(answers.get(2));
        fourthQuestion.setText(answers.get(3));
    }

    Boolean getAnswer() {
        if (radioGroup == null) {
            return false;
        }
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.firstOption:
                return questionsModel.getAnswer() == 1;
            case R.id.secondOption:
                return questionsModel.getAnswer() == 2;
            case R.id.thirdOption:
                return questionsModel.getAnswer() == 3;
            case R.id.fourthOption:
                return questionsModel.getAnswer() == 4;
            default:
                return false;
        }
    }
}
