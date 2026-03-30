package com.example.oop_week11.repository;

import com.example.oop_week11.entity.Match;
import com.example.oop_week11.iterator.MatchIterator;

import java.util.List;
import java.util.Locale;

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

    public List<Match> search(String query) {
        String normalizedQuery = normalize(query);
        if (normalizedQuery.isEmpty()) {
            return getAll();
        }

        return filter(match ->
                contains(match.getTeamA(), normalizedQuery)
                        || contains(match.getTeamB(), normalizedQuery)
                        || contains(match.getName(), normalizedQuery)
                        || contains(match.getDate(), normalizedQuery)
                        || contains(match.getLocation(), normalizedQuery)
                        || (match.getScoreA() + "-" + match.getScoreB()).contains(normalizedQuery)
        );
    }

    @Override
    public MatchIterator iterator() {
        return new MatchIterator(getAll());
    }

    private String normalize(String query) {
        return query == null ? "" : query.trim().toLowerCase(Locale.ROOT);
    }

    private boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
