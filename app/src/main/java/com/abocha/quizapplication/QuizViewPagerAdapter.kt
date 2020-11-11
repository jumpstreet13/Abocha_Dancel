package com.abocha.quizapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class QuizViewPagerAdapter(
    activity: FragmentActivity,
    val fragments: List<QuizFragment>
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment = fragments[position]

    override fun getItemCount(): Int = fragments.size
}
