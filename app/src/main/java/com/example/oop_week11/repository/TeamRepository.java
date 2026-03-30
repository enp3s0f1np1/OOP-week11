package com.example.oop_week11.repository;

import com.example.oop_week11.entity.Team;
import com.example.oop_week11.iterator.TeamIterator;

import java.util.List;
import java.util.Locale;

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

    public List<Team> search(String query) {
        String normalizedQuery = normalize(query);
        if (normalizedQuery.isEmpty()) {
            return getAll();
        }

        return filter(team ->
                contains(team.getName(), normalizedQuery)
                        || contains(team.getCountry(), normalizedQuery)
                        || contains(team.getLeague(), normalizedQuery)
                        || contains(team.getStadium(), normalizedQuery)
                        || String.valueOf(team.getSince()).contains(normalizedQuery)
        );
    }

    @Override
    public TeamIterator iterator() {
        return new TeamIterator(getAll());
    }

    private String normalize(String query) {
        return query == null ? "" : query.trim().toLowerCase(Locale.ROOT);
    }

    private boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
