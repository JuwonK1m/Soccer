package com.kimjuwon.soccer.domain;

import lombok.Builder;

@Builder
public class Player {
    private Integer ranking;
    private String name;
    private String clubName;
    private Integer played;
    private Integer goals;
    private Integer assists;

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
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    public String getClubName() {
        return clubName;
    }
    public void setPlayed(Integer played) {
        this.played = played;
    }
    public Integer getPlayed() {
        return played;
    }
    public void setGoals(Integer goals) {
        this.goals = goals;
    }
    public Integer getGoals() {
        return goals;
    }
    public void setAssists(Integer assists) {
        this.assists = assists;
    }
    public Integer getAssists() {
        return assists;
    }
}
