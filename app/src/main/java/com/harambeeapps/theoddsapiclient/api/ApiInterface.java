package com.harambeeapps.theoddsapiclient.api;

import com.harambeeapps.theoddsapiclient.models.Data;
import com.harambeeapps.theoddsapiclient.models.SportListData;
import com.harambeeapps.theoddsapiclient.models.SportOdds;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 2ndgengod on 9/28/2020.
 */

public  interface ApiInterface {

    @GET(HttpParams.ALLODDS)
    Call<Data> getSportOdds(@Query("apiKey") String apiKey, @Query("sport") String sport, @Query("region") String region, @Query("mkt") String mkt);

    @GET(HttpParams.ALLSPORTS)
    Call<SportListData> getAllSports(@Query("apiKey") String apiKey);

}
