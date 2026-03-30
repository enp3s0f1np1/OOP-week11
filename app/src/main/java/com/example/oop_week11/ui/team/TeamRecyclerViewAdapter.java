package com.example.oop_week11.ui.team;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oop_week11.databinding.FragmentTeamBinding;
import com.example.oop_week11.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamRecyclerViewAdapter extends RecyclerView.Adapter<TeamRecyclerViewAdapter.ViewHolder> {

    private final List<Team> teams = new ArrayList<>();

    public TeamRecyclerViewAdapter(List<Team> teams) {
        updateTeams(teams);
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentTeamBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.team = team;
        holder.titleView.setText(team.getName());
        holder.contentView.setText(team.getLeague() + " | " + team.getCountry() + "\n" + team.getStadium() + " | Founded " + team.getSince());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void updateTeams(List<Team> updatedTeams) {
        teams.clear();
        teams.addAll(updatedTeams);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleView;
        public final TextView contentView;
        public Team team;

        public ViewHolder(FragmentTeamBinding binding) {
            super(binding.getRoot());
            titleView = binding.itemNumber;
            contentView = binding.content;
        }
    }
}
