package com.example.oop_week11.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.oop_week11.ui.match.MatchFragment;
import com.example.oop_week11.ui.player.PlayerFragment;
import com.example.oop_week11.ui.team.TeamFragment;

import java.util.Arrays;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final List<String> titles;
    private final List<Fragment> fragments;

    public ViewPagerAdapter(@NonNull FragmentActivity activity, List<String> titles) {
        super(activity);
        this.titles = titles;
        this.fragments = Arrays.asList(
                PlayerFragment.newInstance(1),
                TeamFragment.newInstance(1),
                MatchFragment.newInstance(1)
        );
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public SearchablePage getSearchablePage(int position) {
        Fragment fragment = fragments.get(position);
        return (SearchablePage) fragment;
    }
}
