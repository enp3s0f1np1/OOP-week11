package com.example.oop_week11.repository;

import com.example.oop_week11.entity.Match;
import com.example.oop_week11.entity.Player;
import com.example.oop_week11.entity.SoccerEntity;
import com.example.oop_week11.entity.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DataProvider<T extends SoccerEntity> {
    private final List<T> items;

    public DataProvider() {
        this.items = new ArrayList<>();
    }

    public DataProvider(Collection<T> items) {
        this.items = new ArrayList<>(items);
    }

    @SafeVarargs
    public static <T extends SoccerEntity> DataProvider<T> of(T... items) {
        return new DataProvider<>(Arrays.asList(items));
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }

    public static DataProvider<Team> createSampleTeams() {
        return DataProvider.of(
                new Team("FC Barcelona", "Spain", "La Liga", "Camp Nou", 1899),
                new Team("Manchester United", "England", "Premier League", "Old Trafford", 1878),
                new Team("Bayern Munich", "Germany", "Bundesliga", "Allianz Arena", 1900),
                new Team("Juventus", "Italy", "Serie A", "Allianz Stadium", 1897),
                new Team("Paris Saint-Germain", "France", "Ligue 1", "Parc des Princes", 1970),
                new Team("Ajax Amsterdam", "Netherlands", "Eredivisie", "Johan Cruyff Arena", 1900),
                new Team("River Plate", "Argentina", "Primera Division", "El Monumental", 1901),
                new Team("Flamengo", "Brazil", "Brasileirao", "Maracana", 1895)
        );
    }

    public static DataProvider<Player> createSamplePlayers() {
        return DataProvider.of(
                new Player("Lionel Messi", 34, "Argentina", "Forward", "FC Barcelona", 10),
                new Player("Cristiano Ronaldo", 36, "Portugal", "Forward", "Juventus", 7),
                new Player("Robert Lewandowski", 32, "Poland", "Forward", "Bayern Munich", 9),
                new Player("Kevin De Bruyne", 29, "Belgium", "Midfielder", "Manchester City", 17),
                new Player("Virgil van Dijk", 30, "Netherlands", "Defender", "Liverpool", 4),
                new Player("Manuel Neuer", 35, "Germany", "Goalkeeper", "Bayern Munich", 1),
                new Player("Kylian Mbappe", 22, "France", "Forward", "Paris Saint-Germain", 7),
                new Player("Erling Haaland", 20, "Norway", "Forward", "Borussia Dortmund", 9),
                new Player("Bruno Fernandes", 26, "Portugal", "Midfielder", "Manchester United", 18),
                new Player("Joshua Kimmich", 26, "Germany", "Midfielder", "Bayern Munich", 6),
                new Player("Jan Oblak", 28, "Slovenia", "Goalkeeper", "Atletico Madrid", 13),
                new Player("Neymar Jr.", 29, "Brazil", "Forward", "Paris Saint-Germain", 10)
        );
    }

    public static DataProvider<Match> createSampleMatches() {
        return DataProvider.of(
                new Match("FC Barcelona", "Real Madrid", "2-1", "La Liga", "2023-04-10", "Camp Nou"),
                new Match("Manchester United", "Liverpool", "0-3", "Premier League", "2023-03-15", "Old Trafford"),
                new Match("Bayern Munich", "Borussia Dortmund", "4-2", "Bundesliga", "2023-04-01", "Allianz Arena"),
                new Match("Juventus", "AC Milan", "1-1", "Serie A", "2023-03-20", "Allianz Stadium"),
                new Match("Paris Saint-Germain", "Lyon", "3-0", "Ligue 1", "2023-04-05", "Parc des Princes"),
                new Match("FC Barcelona", "Bayern Munich", "0-3", "Champions League", "2023-02-28", "Camp Nou"),
                new Match("Manchester City", "Paris Saint-Germain", "2-1", "Champions League", "2023-03-08", "Etihad Stadium"),
                new Match("Liverpool", "Ajax Amsterdam", "1-0", "Champions League", "2023-03-01", "Anfield")
        );
    }
}
