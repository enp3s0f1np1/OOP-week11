package com.example.oop_week11.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.oop_week11.ui.match.MatchFragment;
import com.example.oop_week11.ui.player.PlayerFragment;
import com.example.oop_week11.ui.team.TeamFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final List<String> titles;

    public ViewPagerAdapter(@NonNull FragmentActivity activity, List<String> titles) {
        super(activity);
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return PlayerFragment.newInstance(1);
            case 1:
                return TeamFragment.newInstance(1);
            case 2:
                return MatchFragment.newInstance(1);
            default:
                throw new IllegalArgumentException("Unsupported tab position: " + position);
        }
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}
