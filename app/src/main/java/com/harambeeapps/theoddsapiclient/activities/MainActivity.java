package com.harambeeapps.theoddsapiclient.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.harambeeapps.theoddsapiclient.R;
import com.harambeeapps.theoddsapiclient.adapters.HomeSportAdapter;
import com.harambeeapps.theoddsapiclient.api.ApiUtilities;
import com.harambeeapps.theoddsapiclient.constants.AppConstant;
import com.harambeeapps.theoddsapiclient.listeners.ListItemClickListener;
import com.harambeeapps.theoddsapiclient.models.Data;
import com.harambeeapps.theoddsapiclient.models.Site;
import com.harambeeapps.theoddsapiclient.models.SportOdds;
import com.harambeeapps.theoddsapiclient.models.Sport;
import com.harambeeapps.theoddsapiclient.models.SportListData;
import com.harambeeapps.theoddsapiclient.utility.ActivityUtilities;
import com.harambeeapps.theoddsapiclient.utility.AdsUtilities;
import com.harambeeapps.theoddsapiclient.utility.AppUtilities;
import com.harambeeapps.theoddsapiclient.utility.RateItDialogFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private Activity mActivity;
    private Context mContext;

    private RelativeLayout mNotificationView;
    private ImageButton mImgBtnSearch;

    private ArrayList<Sport> mSportList;
    private List<SportListData> mSportDataList;
    private ArrayList<Sport> mChildSportList;
    private int mItemCount = 5, mPageNo = 1;

    private ArrayList<SportOdds> mOddsData;
    private ArrayList<Site> mSiteList;
    private Data data;

    private HomeSportAdapter mSportAdapter = null;
    private RecyclerView mSportRecycler;



    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RelativeLayout mLytFeatured, mLytSports, mLytRecent, mBottomLayout;

    private boolean mUserScrolled = true;
    private int mRecentPageNo = 1, mPastVisibleItems, mVisibleItemCount, mTotalItemCount;
    private GridLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RateItDialogFragment.show(this, getSupportFragmentManager());

        initVar();
        initView();
        loadData();
        initListener();

    }

    @Override
    protected void onPause() {
        super.onPause();

        //unregister broadcast receiver
        LocalBroadcastManager.getInstance(this).unregisterReceiver(newNotificationReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //register broadcast receiver
        IntentFilter intentFilter = new IntentFilter(AppConstant.NEW_NOTI);
        LocalBroadcastManager.getInstance(this).registerReceiver(newNotificationReceiver, intentFilter);
       // initNotification();

        // load full screen ad
        AdsUtilities.getInstance(mContext).loadFullScreenAd(mActivity);
    }

    // received new broadcast
    private BroadcastReceiver newNotificationReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
         //   initNotification();
        }
    };


    @Override
    public void onBackPressed() {
        AppUtilities.tapPromptToExit(mActivity);
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }

    private void initVar() {
        mActivity = MainActivity.this;
        mContext = getApplicationContext();
        Intent intent = getIntent();

        mSportList = new ArrayList<>();
        mChildSportList = new ArrayList<>();
        mOddsData = new ArrayList<>();
        mSiteList = new ArrayList<>();
    }

    private void initView() {
        setContentView(R.layout.activity_main);


        mSportRecycler = (RecyclerView) findViewById(R.id.rvCategories);
        mSportRecycler.setLayoutManager(new GridLayoutManager(mActivity, 3, GridLayoutManager.VERTICAL, false));
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        mSportRecycler.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        mSportAdapter = new HomeSportAdapter(mContext, mChildSportList);
        mSportRecycler.setAdapter(mSportAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        mLytSports = (RelativeLayout) findViewById(R.id.lyt_categories);


        initToolbar(false);
        initDrawer();
        initLoader();
    }

    private void initListener() {

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mLytSports.setVisibility(View.GONE);

                mRecentPageNo = 1;

                mSportList.clear();
                mChildSportList.clear();
                mOddsData.clear();

                loadData();
            }
        });


        mSportAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Sport model = mChildSportList.get(position);
               //   AppUtilities.showToast(getApplicationContext(), model.getGroup());
                ActivityUtilities.getInstance().subCategoryListActivity(mActivity,GameDetailsActivity.class,model.getKey(),model.getGroup(),
                        model.getDetails(),model.getTitle(),false
                        );
            }
        });

    }

    private void swipeRefreshController(boolean enable) {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setEnabled(enable);
        }
    }

    private void loadData() {
        showLoader();


        loadSports();

        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }

        // show banner ads
      //  AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));
    }


    private void loadSports() {
        ApiUtilities.getApiInterface().getAllSports(AppConstant.APIKEY).enqueue(new Callback<SportListData>(){

            @Override
            public void onResponse(Call<SportListData> call, Response<SportListData> response) {
                if (response.isSuccessful()){

                  //  AppUtilities.showToast(getApplicationContext(),response.body().getData().toString());
                    assert response.body() != null;
                    mSportList.addAll(response.body().getData());

                    if (response.body().getSuccess() == AppConstant.TRUE) {
                        mChildSportList.addAll(mSportList);
                    }

                    mSportAdapter.notifyDataSetChanged();
                    mLytSports.setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void onFailure(Call<SportListData> call, Throwable t) {

            }
        });
    }



    private void hideMoreItemLoader() {
        mBottomLayout.setVisibility(View.GONE);
        mUserScrolled = true;
    }

    private void updateRecyclerView() {
        mBottomLayout.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                mRecentPageNo++;

            }
        }, 5000);

    }

  /*  private void updateUI() {

        if (mBookmarkDbController == null) {
            mBookmarkDbController = new BookmarkDbController(mActivity);
        }

        mBookmarkList.clear();
        mBookmarkList.addAll(mBookmarkDbController.getAllData());

        for (int i = 0; i < mRecentPostList.size(); i++) {
            boolean isBookmarkSet = false;
            for (int j = 0; j < mBookmarkList.size(); j++) {
                if (mRecentPostList.get(i).getID() == mBookmarkList.get(j).getPostId()) {
                    mRecentPostList.get(i).setBookmark(true);
                    isBookmarkSet = true;
                    break;
                }
            }
            if (!isBookmarkSet) {
                mRecentPostList.get(i).setBookmark(false);
            }
        }

        if (mRecentPostList.size() == 0) {
            showEmptyView();
        } else {
            mRecentAdapter.notifyDataSetChanged();
            hideLoader();
        }

    }*/

  /*  public void initNotification() {
        NotificationDbController notificationDbController = new NotificationDbController(mContext);
        TextView notificationCount = (TextView) findViewById(R.id.notificationCount);
        notificationCount.setVisibility(View.INVISIBLE);

        ArrayList<NotificationModel> notiArrayList = notificationDbController.getUnreadData();

        if (notiArrayList != null && !notiArrayList.isEmpty()) {
            int totalUnread = notiArrayList.size();
            if (totalUnread > 0) {
                notificationCount.setVisibility(View.VISIBLE);
                notificationCount.setText(String.valueOf(totalUnread));
            } else {
                notificationCount.setVisibility(View.INVISIBLE);
            }
        }
    }*/
}

