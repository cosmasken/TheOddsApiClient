package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 9/29/2020.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Odds {

    @SerializedName("h2h")
    @Expose
    private List<Double> h2h = null;

    public List<Double> getH2h() {
        return h2h;
    }

    public void setH2h(List<Double> h2h) {
        this.h2h = h2h;
    }

}