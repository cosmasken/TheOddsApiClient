package com.harambeeapps.theoddsapiclient.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.harambeeapps.theoddsapiclient.R;
import com.harambeeapps.theoddsapiclient.listeners.ListItemClickListener;
import com.harambeeapps.theoddsapiclient.models.Odds;

import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class FeaturedOddsAdapter extends RecyclerView.Adapter<FeaturedOddsAdapter.ViewHolder> {

    private Context mContext;

    private ArrayList<Odds> mOddsList;
    private ListItemClickListener mItemClickListener;

    public FeaturedOddsAdapter(Context mContext, ArrayList<Odds> mOddsList) {
        this.mContext = mContext;
        this.mOddsList = mOddsList;
    }

    public void setItemClickListener(ListItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_card, parent, false);
        return new ViewHolder(view, viewType, mItemClickListener);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView homeOdds, drawOdds, awayOdds;
        private CardView cardView;
        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            // Find all views ids
            homeOdds = (TextView) itemView.findViewById(R.id.homeOdds);
            drawOdds = (TextView) itemView.findViewById(R.id.drawOdds);
            awayOdds = (TextView) itemView.findViewById(R.id.awayOdds);
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
        return (null != mOddsList ? mOddsList.size() : 0);
    }

    @Override
    public void onBindViewHolder(ViewHolder mainHolder, int position) {
        final Odds model = mOddsList.get(position);

        // setting data over views


        mainHolder.homeOdds.setText(model.getH2h().toString());
        mainHolder.drawOdds.setText(model.getH2h().toString());
        mainHolder.awayOdds.setText(model.getH2h().toString());


    }
}