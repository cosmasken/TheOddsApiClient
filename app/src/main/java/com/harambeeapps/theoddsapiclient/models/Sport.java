package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 9/29/2020.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sport {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("title")
    @Expose
    private String title;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}