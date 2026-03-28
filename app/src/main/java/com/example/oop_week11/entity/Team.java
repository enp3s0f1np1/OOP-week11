package com.example.oop_week11.entity;

public class Team implements SoccerEntity {
    private String name;
    private String country;
    private String league;
    private String stadium;
    private int since;

    public Team(String name, String country, String league, String stadium, int since) {
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.since = since;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public String getStadium() {
        return stadium;
    }

    public int getSince() {
        return since;
    }
}
