package com.abocha.quizapplication

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class QuizViewPagerAdapter(
    activity: FragmentActivity,
    private val questionsModels: List<QuestionsModel>
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment = QuizFragment().apply {
        arguments = bundleOf(QUESTIONS_KEY to questionsModels[position])
    }

    override fun getItemCount(): Int = questionsModels.size
}
