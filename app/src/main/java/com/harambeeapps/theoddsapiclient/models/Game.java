package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 10/25/2020.
 */

public class Game {
    private String homeTeam;
    private String awayTeam;
    private String League;
    private long commenceTime;

    public Game() {

    }

    public Game(String homeTeam, String awayTeam, String league, long commenceTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        League = league;
        this.commenceTime = commenceTime;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public long getCommenceTime() {
        return commenceTime;
    }

    public void setCommenceTime(long commenceTime) {
        this.commenceTime = commenceTime;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }
}
