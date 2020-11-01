package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 9/28/2020.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SportListData {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<Sport> sportList = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Sport> getData() {
        return sportList;
    }

    public void setData(List<Sport> sportList) {
        this.sportList = sportList;
    }

}