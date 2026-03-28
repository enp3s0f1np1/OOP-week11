package com.example.oop_week11.iterator;

import com.example.oop_week11.entity.Player;

import java.util.List;

public class PlayerIterator extends ListIterator<Player> {
    public PlayerIterator(List<Player> players) {
        super(players);
    }
}
