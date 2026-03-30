package com.example.oop_week11.ui.match;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oop_week11.databinding.FragmentMatchBinding;
import com.example.oop_week11.entity.Match;

import java.util.List;

public class MatchRecyclerViewAdapter extends RecyclerView.Adapter<MatchRecyclerViewAdapter.ViewHolder> {

    private final List<Match> matches;

    public MatchRecyclerViewAdapter(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentMatchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Match match = matches.get(position);
        holder.match = match;
        holder.titleView.setText(match.getTeamA() + " vs " + match.getTeamB());
        holder.contentView.setText("Score " + match.getScoreA() + " - " + match.getScoreB() + " | " + match.getName() + "\n" + match.getDate() + " | " + match.getLocation());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleView;
        public final TextView contentView;
        public Match match;

        public ViewHolder(FragmentMatchBinding binding) {
            super(binding.getRoot());
            titleView = binding.itemNumber;
            contentView = binding.content;
        }
    }
}
