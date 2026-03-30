package com.example.oop_week11.repository;

import com.example.oop_week11.entity.Player;
import com.example.oop_week11.iterator.PlayerIterator;

import java.util.List;
import java.util.Locale;

public class PlayerRepository extends Repository<Player> {
    public PlayerRepository() {
        super();
    }

    public PlayerRepository(DataProvider<Player> dataProvider) {
        super(dataProvider);
    }

    public List<Player> filterByTeam(String teamName) {
        return filter(player -> player.getTeam().equals(teamName));
    }

    public List<Player> search(String query) {
        String normalizedQuery = normalize(query);
        if (normalizedQuery.isEmpty()) {
            return getAll();
        }

        return filter(player ->
                contains(player.getName(), normalizedQuery)
                        || contains(player.getCountry(), normalizedQuery)
                        || contains(player.getPosition(), normalizedQuery)
                        || contains(player.getTeam(), normalizedQuery)
                        || String.valueOf(player.getAge()).contains(normalizedQuery)
                        || String.valueOf(player.getJerseyNumber()).contains(normalizedQuery)
        );
    }

    @Override
    public PlayerIterator iterator() {
        return new PlayerIterator(getAll());
    }

    private String normalize(String query) {
        return query == null ? "" : query.trim().toLowerCase(Locale.ROOT);
    }

    private boolean contains(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
