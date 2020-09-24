package com.kimjuwon.soccer.domain;

import lombok.Builder;

@Builder
public class Club {
    private Integer ranking;
    private String name;
    private Integer played;
    private Integer points;
    private Integer won;
    private Integer drawn;
    private Integer lost;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private String goalsDifference;

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Integer getRanking() {
        return ranking;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPlayed(Integer played) {
        this.played = played;
    }
    public Integer getPlayed() {
        return played;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    public Integer getPoints() {
        return points;
    }
    public void setWon(Integer won) {
        this.won = won;
    }
    public Integer getWon() {
        return won;
    }
    public void setDrawn(Integer drawn) {
        this.drawn = drawn;
    }
    public Integer getDrawn() {
        return drawn;
    }
    public void setLost(Integer lost) {
        this.lost = lost;
    }
    public Integer getLost() {
        return lost;
    }
    public void setGoals_for(Integer goalsFor) {
        this.goalsFor = goalsFor;
    }
    public Integer getGoalsFor() {
        return goalsFor;
    }
    public void setGoals_against(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }
    public void setGoalsDifference(String goalsDifference) {
        this.goalsDifference = goalsDifference;
    }
    public String getGoalsDifference() {
        return goalsDifference;
    }
}
