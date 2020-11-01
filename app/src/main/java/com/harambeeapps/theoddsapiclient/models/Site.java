package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 9/29/2020.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Site {

    @SerializedName("site_key")
    @Expose
    private String siteKey;
    @SerializedName("site_nice")
    @Expose
    private String siteNice;
    @SerializedName("last_update")
    @Expose
    private Integer lastUpdate;
    @SerializedName("odds")
    @Expose
    private Odds odds;

    public String getSiteKey() {
        return siteKey;
    }

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }

    public String getSiteNice() {
        return siteNice;
    }

    public void setSiteNice(String siteNice) {
        this.siteNice = siteNice;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Odds getOdds() {
        return odds;
    }

    public void setOdds(Odds odds) {
        this.odds = odds;
    }

}