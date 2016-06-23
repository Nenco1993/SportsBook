package com.example.neven.sportsbooks_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import dataFromServer.MyApplication;

import java.util.List;

/**
 * Created by Neven on 19.6.2016..
 */
public class SportsBookTabListAdapter extends BaseAdapter {
   public static int defaultTextColor;

    MyApplication app = MyApplication.getInstance();
    Context context;
    List<String> itemNames;
    ImageLoader imageLoader = ImageLoader.getInstance();

    public SportsBookTabListAdapter(Context context, List<String> itemNames) {
        this.itemNames = itemNames;
        this.context = context;
    }


    @Override
    public int getCount() {
        return itemNames.size();
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


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sports_book_tab_listview_design, null);
        }


        TextView tvItemName = (TextView) convertView.findViewById(R.id.sbtTvMainItemID);
        ImageView ivLogo = (ImageView) convertView.findViewById(R.id.htLogoID);
        defaultTextColor = tvItemName.getTextColors().getDefaultColor();

        tvItemName.setText(itemNames.get(position));

        imageLoader.displayImage(app.getAllSportsBookTabLogos().get(position), ivLogo);


        return convertView;

    }
}
