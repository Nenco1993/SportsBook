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
 * Created by Neven on 24.6.2016..
 */
public class PromotionsTabListAdapter extends BaseAdapter {

    Context context;
    List<String> promotionName;
    List<String> promotionDetails;
    MyApplication app = MyApplication.getInstance();
    ImageLoader imageLoader = ImageLoader.getInstance();

    public PromotionsTabListAdapter(Context context, List<String> promotionDetails, List<String> promotionName) {
        this.context = context;
        this.promotionDetails = promotionDetails;
        this.promotionName = promotionName;
    }

    @Override
    public int getCount() {
        return promotionName.size();
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
        View v = inflater.inflate(R.layout.listview_layout_for_promotions_tab, parent, false);

        ImageView logo = (ImageView) v.findViewById(R.id.htLogoID);
        TextView mainItem = (TextView) v.findViewById(R.id.ptMainItemID);
        TextView subItem = (TextView) v.findViewById(R.id.ptSubItemID);

        mainItem.setText(promotionName.get(position));
        subItem.setText(promotionDetails.get(position));
        imageLoader.displayImage(app.getListOfLogosForPromotionsTab().get(position), logo);


        return v;

    }
}
