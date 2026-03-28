package com.example.oop_week11.repository;

import com.example.oop_week11.entity.Match;
import com.example.oop_week11.iterator.MatchIterator;

import java.util.List;

public class MatchRepository extends Repository<Match> {
    public MatchRepository() {
        super();
    }

    public MatchRepository(DataProvider<Match> dataProvider) {
        super(dataProvider);
    }

    public List<Match> filterByTeam(String teamName) {
        return filter(match -> match.getTeamA().equals(teamName) || match.getTeamB().equals(teamName));
    }

    @Override
    public MatchIterator iterator() {
        return new MatchIterator(getAll());
    }
}
