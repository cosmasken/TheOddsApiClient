package com.harambeeapps.theoddsapiclient.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textview.MaterialTextView;
import com.harambeeapps.theoddsapiclient.R;
import com.harambeeapps.theoddsapiclient.adapters.GameAdapter;
import com.harambeeapps.theoddsapiclient.adapters.HomeSportAdapter;
import com.harambeeapps.theoddsapiclient.api.ApiUtilities;
import com.harambeeapps.theoddsapiclient.constants.AppConstant;
import com.harambeeapps.theoddsapiclient.models.Data;
import com.harambeeapps.theoddsapiclient.models.Game;
import com.harambeeapps.theoddsapiclient.models.Site;
import com.harambeeapps.theoddsapiclient.models.Sport;
import com.harambeeapps.theoddsapiclient.models.SportOdds;
import com.harambeeapps.theoddsapiclient.models.Teams;
import com.harambeeapps.theoddsapiclient.utility.AppUtilities;
import com.harambeeapps.theoddsapiclient.utility.RateItDialogFragment;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 2ndgengod on 10/21/2020.
 */

public  class GameDetailsActivity extends BaseActivity {

    private Activity mActivity;
    private Context mContext;
    private ArrayList<SportOdds> mOddsData;
    private ArrayList<Game> gameArrayList;
    private ArrayList<Site> mSiteArrayList;
    private ArrayList<String> mTeamArrayList;
    private SportOdds sportOdds;
    private Teams teams;
    private String homeTeam,awayTeam,commenceTime,sportKey;
    private GameAdapter mGameAdapter = null;
    private RecyclerView mGameRecyclerview;



    private SwipeRefreshLayout mSwipeRefreshLayout;

    private String mSportKey,mSportGroup,mSportDetails,mSportTitle,mRegion;
    private MaterialTextView sportTv,timeTv,homeTv,awayTv;

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RateItDialogFragment.show(this, getSupportFragmentManager());
        initVar();
        initView();
        loadData();

    }
    private void initView() {
        setContentView(R.layout.gamedetails);
        mGameRecyclerview = (RecyclerView) findViewById(R.id.gameRecyclerview);
        mGameRecyclerview.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        mGameAdapter = new GameAdapter(mContext, gameArrayList);
        mGameRecyclerview.setAdapter(mGameAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

    }
    private void loadData() {
        showLoader();


        loadOdds(mSportKey,mRegion,"h2h");

        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }

        // show banner ads
        //  AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));
    }
    private void initVar() {
        mActivity = GameDetailsActivity.this;
        mContext = mActivity.getApplicationContext();

        gameArrayList = new ArrayList<>();
        Intent intent = getIntent();
        if (intent != null) {
            mSportKey = intent.getStringExtra(AppConstant.BUNDLE_KEY_SPORT_KEY);
            mSportGroup = intent.getStringExtra(AppConstant.BUNDLE_KEY_SPORT_GROUP);
            mSportDetails = intent.getStringExtra(AppConstant.BUNDLE_KEY_SPORT_DETAILS);
            mSportTitle = intent.getStringExtra(AppConstant.BUNDLE_KEY_SPORT_TITLE);
            getRegion(mSportKey);

        }

       /* mChildCategoryList = new ArrayList<>();
        mCategoryWisePostList = new ArrayList<>();
        mBookmarkList = new ArrayList<>();*/
    }

    public void getRegion(String sportKey){
        switch (sportKey) {
            case "soccer_epl":
            case "soccer_spl":
            case "soccer_england_league2":
            case "soccer_england_league1":
            case "soccer_efl_champ":
            case"soccer_fa_cup":
                mRegion = "uk";
                break;
            case "americanfootball_ncaaf":
            case "americanfootball_nfl":
            case "baseball_mlb":
            case "soccer_usa_mls":
            case "soccer_mexico_ligamx":
            case "mma_mixed_martial_arts":
            case"soccer_brazil_campeonato":
            case "soccer_argentina_primera_division":
                mRegion = "us";
                break;
            case "cricket_test_match":
            case "cricket_ipl":
            case "cricket_odi":
            case "soccer_china_superleague":
            case "rugbyleague_nrl":
            case"soccer_japan_j_league":
                mRegion = "au";
                break;
            case "soccer_belgium_first_div":
            case "soccer_switzerland_superleague":
            case "soccer_sweden_superettan":
            case "soccer_sweden_allsvenskan":
            case "soccer_spain_la_liga":
            case "soccer_spain_segunda_division":
            case "soccer_russia_premier_league":
            case "soccer_portugal_primeira_liga":
            case "soccer_norway_eliteserien":
            case "soccer_netherlands_eredivisie":
            case "soccer_germany_bundesliga2":
            case "soccer_germany_bundesliga":
            case "soccer_france_ligue_two":
            case "soccer_france_ligue_one":
            case "soccer_finland_veikkausliiga":
            case "soccer_denmark_superliga":
            case "basketball_euroleague":
            case"soccer_italy_serie_a":
            case"soccer_italy_serie_b":
            case"soccer_league_of_ireland":
            case"soccer_turkey_super_league":
            case"soccer_uefa_champs_league":
            case"soccer_uefa_europa_league":
                mRegion = "eu";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + sportKey);
        }
    }

    public void loadOdds(String sport, String region, String mkt) {
        ApiUtilities.getApiInterface().getSportOdds(AppConstant.APIKEY,sport,region,mkt).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                if (response.isSuccessful()) {
                    data = response.body();
                    mOddsData= new ArrayList<>( data.getData());
                    for (int i = 0; i < mOddsData.size(); i++) {
                        SportOdds sportOdds = mOddsData.get(i);
                        Game game = new Game();

                        mSiteArrayList= new ArrayList<>(sportOdds.getSites());
                        mTeamArrayList = new ArrayList<>(sportOdds.getTeams());
                        game.setHomeTeam(mTeamArrayList.get(0));
                       game.setAwayTeam(mTeamArrayList.get(1));
                        game.setCommenceTime(sportOdds.getCommenceTime());
                       game.setLeague(sportOdds.getSportNice());
                       gameArrayList.add(game);
                    }
                    mGameAdapter.notifyDataSetChanged();
                    }


                    hideLoader();
                }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
