package com.example.oop_week11.repository;

import com.example.oop_week11.entity.Player;

import java.util.List;

public class PlayerRepository extends Repository<Player> {
    public PlayerRepository() {
        super();
    }

    public List<Player> filterByTeam(String teamName) {
        return filter(player -> player.getTeam().equals(teamName));
    }
}
