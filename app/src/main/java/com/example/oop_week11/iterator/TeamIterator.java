package com.example.oop_week11.iterator;

import com.example.oop_week11.entity.Team;

import java.util.List;

public class TeamIterator extends ListIterator<Team> {
    public TeamIterator(List<Team> teams) {
        super(teams);
    }
}
