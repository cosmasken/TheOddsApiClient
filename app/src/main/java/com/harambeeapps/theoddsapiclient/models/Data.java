package com.harambeeapps.theoddsapiclient.models;

/**
 * Created by 2ndgengod on 9/28/2020.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<SportOdds> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<SportOdds> getData() {
        return data;
    }

    public void setData(List<SportOdds> data) {
        this.data = data;
    }

}