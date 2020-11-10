package com.abocha.quizapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment

const val QUESTIONS_KEY = "questions_key"

class QuizFragment : Fragment() {

    private lateinit var firstQuestion: RadioButton
    private lateinit var secondQuestion: RadioButton
    private lateinit var thirdQuestion: RadioButton
    private lateinit var fourthQuestion: RadioButton
    private lateinit var question: TextView
    private lateinit var questionsModel: QuestionsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            questionsModel = it.getSerializable(QUESTIONS_KEY) as QuestionsModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_layout, container, false)
        firstQuestion = view.findViewById(R.id.firstOption)
        secondQuestion = view.findViewById(R.id.secondOption)
        thirdQuestion = view.findViewById(R.id.thirdOption)
        fourthQuestion = view.findViewById(R.id.fourthOption)
        question = view.findViewById(R.id.question)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val answers = questionsModel.answers

        question.text = questionsModel.question
        firstQuestion.text = answers[0]
        secondQuestion.text = answers[1]
        thirdQuestion.text = answers[2]
        fourthQuestion.text = answers[3]
    }

    companion object {

        fun newInstance(questionsModel: QuestionsModel) =
            QuizFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(QUESTIONS_KEY, questionsModel)
                }
            }
    }
}