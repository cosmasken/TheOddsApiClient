package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 9/28/2020.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teams {

    @SerializedName("teams")
    @Expose
    private List<String> teams = null;

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

}