package com.example.neven.sportsbooks_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import dataFromServer.MyApplication;

import java.util.List;

/**
 * Created by Neven on 23.6.2016..
 */
public class RatingsTabListAdapter extends BaseAdapter {

    List<String> lSportsBookName;
    List<String> lRatings;
    Context context;
    MyApplication app = MyApplication.getInstance();

    public RatingsTabListAdapter(Context context, List<String> lRatings, List<String> lSportsBookName) {
        this.context = context;
        this.lRatings = lRatings;
        this.lSportsBookName = lSportsBookName;
    }

    @Override
    public int getCount() {
        return lSportsBookName.size();

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.listview_layout_for_ratings_tab, parent,false);

        TextView tvSportsBookName = (TextView) v.findViewById(R.id.tvRtSportsBookNameID);
        Button bRatings = (Button) v.findViewById(R.id.bRtRatingsID);

       // bRatings.setText(app.getListOfAllRatingsNeeded().get(position));
       // tvSportsBookName.setText(app.getListOfAllRatingsNames().get(position));

        bRatings.setText(lRatings.get(position));
        tvSportsBookName.setText(lSportsBookName.get(position));



        return v;


    }
}
