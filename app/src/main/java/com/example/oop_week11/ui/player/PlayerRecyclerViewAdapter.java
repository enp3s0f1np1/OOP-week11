package com.example.oop_week11.ui.player;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oop_week11.databinding.FragmentPlayerBinding;
import com.example.oop_week11.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRecyclerViewAdapter extends RecyclerView.Adapter<PlayerRecyclerViewAdapter.ViewHolder> {

    private final List<Player> players = new ArrayList<>();

    public PlayerRecyclerViewAdapter(List<Player> players) {
        updatePlayers(players);
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentPlayerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Player player = players.get(position);
        holder.player = player;
        holder.titleView.setText(player.getName());
        holder.contentView.setText("#" + player.getJerseyNumber() + " | " + player.getPosition() + " | " + player.getTeam() + "\n" + player.getCountry() + " | Age " + player.getAge());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public void updatePlayers(List<Player> updatedPlayers) {
        players.clear();
        players.addAll(updatedPlayers);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleView;
        public final TextView contentView;
        public Player player;

        public ViewHolder(FragmentPlayerBinding binding) {
            super(binding.getRoot());
            titleView = binding.itemNumber;
            contentView = binding.content;
        }
    }
}
