package com.example.oop_week11.entity;

public class Player implements SoccerEntity {
    private final String name;
    private final int age;
    private final String country;
    private final String position;
    private final String team;

    private final int jerseyNumber;

    public Player(String name, int age, String country, String position, String team, int jerseyNumber) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.position = position;
        this.team = team;
        this.jerseyNumber = jerseyNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }
}
