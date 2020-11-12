package com.abocha.quizapplication.java;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.abocha.quizapplication.java.QuizFragmentJava;
import java.util.List;

public class QuizViewPagerAdapterJava extends FragmentStateAdapter {

    private final List<QuizFragmentJava> fragments;

    public QuizViewPagerAdapterJava(@NonNull final FragmentActivity fragmentActivity, List<QuizFragmentJava> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(final int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    List<QuizFragmentJava> getFragments(){
        return fragments;
    }
}
