package com.abocha.quizapplication.kotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.abocha.quizapplication.kotlin.QuizFragment

class QuizViewPagerAdapter(
    activity: FragmentActivity,
    val fragments: List<QuizFragment>
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment = fragments[position]

    override fun getItemCount(): Int = fragments.size
}
