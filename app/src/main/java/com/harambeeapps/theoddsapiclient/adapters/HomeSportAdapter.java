package com.harambeeapps.theoddsapiclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.harambeeapps.theoddsapiclient.R;
import com.harambeeapps.theoddsapiclient.listeners.ListItemClickListener;
import com.harambeeapps.theoddsapiclient.models.Odds;
import com.harambeeapps.theoddsapiclient.models.Sport;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HomeSportAdapter extends RecyclerView.Adapter<HomeSportAdapter.ViewHolder> {

    private Context mContext;

    private ArrayList<Sport> mSportList;
    private ListItemClickListener mItemClickListener;

    public HomeSportAdapter(Context mContext, ArrayList<Sport> mSportList) {
        this.mContext = mContext;
        this.mSportList = mSportList;
    }

    public void setItemClickListener(ListItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sport_card, parent, false);
        return new ViewHolder(view, viewType, mItemClickListener);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView key, group, details,title;
        private Boolean active;
        private CardView cardView;
        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            // Find all views ids
            key = (TextView) itemView.findViewById(R.id.key);
            group = (TextView) itemView.findViewById(R.id.group);
            details = (TextView) itemView.findViewById(R.id.details);
            title = (TextView) itemView.findViewById(R.id.title);
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
        return (null != mSportList ? mSportList.size() : 0);
    }

    @Override
    public void onBindViewHolder(ViewHolder mainHolder, int position) {
        final Sport model = mSportList.get(position);

        // setting data over views


        mainHolder.key.setText(model.getKey());
        mainHolder.group.setText(model.getGroup());
        mainHolder.details.setText(model.getDetails());
        mainHolder.title.setText(model.getTitle());


    }
}