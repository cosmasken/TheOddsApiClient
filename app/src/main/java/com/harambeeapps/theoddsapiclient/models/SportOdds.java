package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 9/29/2020.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SportOdds {

    @SerializedName("sport_key")
    @Expose
    private String sportKey;
    @SerializedName("sport_nice")
    @Expose
    private String sportNice;
    @SerializedName("teams")
    @Expose
    private List<String> teams = null;
    @SerializedName("commence_time")
    @Expose
    private Integer commenceTime;
    @SerializedName("home_team")
    @Expose
    private String homeTeam;
    @SerializedName("sites")
    @Expose
    private List<Site> sites = null;
    @SerializedName("sites_count")
    @Expose
    private Integer sitesCount;

    public String getSportKey() {
        return sportKey;
    }

    public void setSportKey(String sportKey) {
        this.sportKey = sportKey;
    }

    public String getSportNice() {
        return sportNice;
    }

    public void setSportNice(String sportNice) {
        this.sportNice = sportNice;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public Integer getCommenceTime() {
        return commenceTime;
    }

    public void setCommenceTime(Integer commenceTime) {
        this.commenceTime = commenceTime;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public Integer getSitesCount() {
        return sitesCount;
    }

    public void setSitesCount(Integer sitesCount) {
        this.sitesCount = sitesCount;
    }

}