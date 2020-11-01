package com.harambeeapps.theoddsapiclient.adapters;

import android.content.Context;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.harambeeapps.theoddsapiclient.R;
import com.harambeeapps.theoddsapiclient.listeners.ListItemClickListener;
import com.harambeeapps.theoddsapiclient.models.Game;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private Context mContext;

    private ArrayList<Game> mGameArrayList;
    private ListItemClickListener mItemClickListener;

    public GameAdapter(Context mContext, ArrayList<Game> mGameArrayList) {
        this.mContext = mContext;
        this.mGameArrayList = mGameArrayList;
    }

    public void setItemClickListener(ListItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_card, parent, false);
        return new ViewHolder(view, viewType, mItemClickListener);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView teamPlaceholder, commenceTime, league;
        private CardView cardView;
        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            // Find all views ids
            teamPlaceholder = (TextView) itemView.findViewById(R.id.teampPH);
            commenceTime = (TextView) itemView.findViewById(R.id.timePH);
            league = (TextView) itemView.findViewById(R.id.sportPH);
            cardView = (CardView) itemView.findViewById(R.id.match_card);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }

    @Override
    public int getItemCount() {
        return (null != mGameArrayList ? mGameArrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(ViewHolder mainHolder, int position) {
        final Game model = mGameArrayList.get(position);


        // setting data over views
        mainHolder.teamPlaceholder.setText(model.getHomeTeam()+ "-"+model.getAwayTeam());
        mainHolder.commenceTime.setText(getDate(model.getCommenceTime()));
        mainHolder.league.setText(model.getLeague());


    }
    public String getDate(long unixSeconds){
        Date date =new Date(unixSeconds*1000L);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm z");
        return simpleDateFormat.format(date);
    }
}