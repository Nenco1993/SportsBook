package com.example.neven.sportsbooks_v2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import dataFromServer.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Neven on 13.6.2016..
 */
public class HomeTabListAdapter extends BaseExpandableListAdapter {


    private Context context;
    private List<String> listDataHeaders;
    private HashMap<String, List<String>> listDataChild;
    private MyApplication app = MyApplication.getInstance();
    ImageLoader imageLoader = ImageLoader.getInstance();


    public HomeTabListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
        this.context = context;
        this.listDataHeaders = listDataHeader;
        this.listDataChild = listChildData;

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {


        return this.listDataChild.get(this.listDataHeaders.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        final String childText = (String) getChild(groupPosition, childPosition);



        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.home_tab_listview_child_design, null);

            // int imageId = this.childImages.get(this.groupImages.get(groupPosition)).get(childPosition);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.htTvMainItemID);
        //TextView tvSubItem = (TextView) convertView.findViewById(R.id.tvSubItemID);
        ImageView logo = (ImageView) convertView.findViewById(R.id.htIvLogoID);


        // tvSubItem.setTextColor(Color.BLACK);
        txtListChild.setTextColor(Color.BLACK);


        txtListChild.setText(childText);


        if (groupPosition==0){

            imageLoader.displayImage(app.getListOfAllHomeTabFirstSectionLogos().get(childPosition),logo);


        }else if (groupPosition==1){

            imageLoader.displayImage(app.getListOfAllHomeTabSecondSectionLogos().get(childPosition),logo);



        }




        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeaders.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {


        return this.listDataHeaders.get(groupPosition);
    }


    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {


        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.home_tab_listview_header_design, null);
        }

        ExpandableListView elv = (ExpandableListView) parent;
        elv.expandGroup(groupPosition);

        TextView tvHeader = (TextView) convertView.findViewById(R.id.tvHeaderID);
        tvHeader.setTypeface(null, Typeface.BOLD);


        tvHeader.setTextColor(Color.BLACK);
        tvHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeaders.size();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
