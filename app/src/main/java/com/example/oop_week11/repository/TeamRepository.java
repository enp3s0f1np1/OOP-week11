package com.example.oop_week11.repository;

import com.example.oop_week11.entity.Team;

import java.util.List;

public class TeamRepository extends Repository<Team> {
    public TeamRepository() {
        super();
    }

    public TeamRepository(DataProvider<Team> dataProvider) {
        super(dataProvider);
    }

    public List<Team> filterByLeague(String league) {
        return filter(team -> team.getLeague().equals(league));
    }
}
