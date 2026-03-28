package com.example.oop_week11.entity;

public class Match implements SoccerEntity {
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;
    private String name;
    private String date;
    private String location;

    public Match(String teamA, String teamB, String score, String name, String date, String location) {
        this.teamA = teamA;
        this.teamB = teamB;

        String[] scores = score.split("-");
        scoreA = Integer.parseInt(scores[0].trim());
        scoreB = Integer.parseInt(scores[1].trim());

        this.name = name;
        this.date = date;
        this.location = location;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
