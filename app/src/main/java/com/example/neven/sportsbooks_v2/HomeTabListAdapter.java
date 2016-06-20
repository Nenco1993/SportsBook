package com.example.neven.sportsbooks_v2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import dataFromServer.MyApplication;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Neven on 13.6.2016..
 */
public class HomeTabListAdapter extends BaseExpandableListAdapter {


    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, List<String>> _listDataChild;
    private List<String> subItemText;
    MyApplication app;

    public HomeTabListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData, List<String> subItemText) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.subItemText = subItemText;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
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
        ImageView childImage = (ImageView) getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.home_tab_listview_child_design, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.tvMainItemID);
        TextView tvSubItem = (TextView) convertView.findViewById(R.id.tvSubItemID);
        ImageView logo = (ImageView) convertView.findViewById(R.id.ivLogoID);


        // tvSubItem.setTextColor(Color.BLACK);
        txtListChild.setTextColor(Color.BLACK);

        txtListChild.setText(childText);

        for (String s2 : app.getAllTinyImages()) {

            MainActivity.imageLoader.displayImage(s2, logo);


        }


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
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
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.home_tab_listview_header_design, null);
        }

        ExpandableListView elv = (ExpandableListView) parent;
        elv.expandGroup(groupPosition);

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.tvHeaderID);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setTextColor(Color.BLACK);
        lblListHeader.setText(headerTitle);

        return convertView;
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
