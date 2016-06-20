package com.example.neven.sportsbooks_v2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.*;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import dataFromServer.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyApplication app;


    private TabHost tabHost;
    private ExpandableListView expandableListView;
    private ImageView ivLogo;
    private ListView listViewForSportsBookTab;
    private ListView listviewForRatingsTab;


    private ImageView slika;
    private ImageView slika2;
    private ImageView slika3;
    private ImageView slika4;


    public static ImageLoader imageLoader;


    TextView tv3;


    private HashMap<String, List<String>> listDataChild;
    private List<String> listDataHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View parentLayout = findViewById(R.id.rootLayout);
        Snackbar.make(parentLayout, "Internet connection must be ON at all time", Snackbar.LENGTH_LONG).show();


        app = (MyApplication) getApplication();


        ivLogo = (ImageView) findViewById(R.id.ivLogoID);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView); //privremeno gone

        listviewForRatingsTab = (ListView) findViewById(R.id.lvRatingTabID);
        slika = (ImageView) findViewById(R.id.imageView);
        slika2 = (ImageView) findViewById(R.id.imageView2);
        slika3 = (ImageView) findViewById(R.id.imageView3);
        slika4 = (ImageView) findViewById(R.id.imageView4);
        tv3 = (TextView) findViewById(R.id.textView3);


        setupTabs();


        displaySportsBookTabListview();
        displayRatingsTabListview();


        //______________________________library za prikazivanje slika____________________________________

        ImageLoaderConfiguration cfg = ImageLoaderConfiguration.createDefault(getApplicationContext());


        imageLoader = ImageLoader.getInstance();
        imageLoader.init(cfg);
        String urlSLike = "https://www.eclecticasoft.com/appdata/ec01000220/img/icon_19.png";
        String url2 = "https://www.eclecticasoft.com/appdata/ec01000220/img/icon_20.png";
        String url3 = "https://www.eclecticasoft.com/appdata/ec01000220/img/icon_21.png";
        String url4 = "https://www.eclecticasoft.com/appdata/ec01000220/img/icon_22.png";
        imageLoader.displayImage(urlSLike, slika);
        imageLoader.displayImage(url2, slika2);
        imageLoader.displayImage(url3, slika3);
        imageLoader.displayImage(url4, slika4);


        //__________________________________________________________________________________________________


//        prepareListDataForHomeTab();
        tabHost.setCurrentTabByTag("tag1");

        // HomeTabListAdapter adapter = new HomeTabListAdapter(getApplicationContext(), listDataHeader, listDataChild, null);
        // expandableListView.setAdapter(adapter);


        // Toast.makeText(MainActivity.this, "podaci dohvaceni", Toast.LENGTH_LONG).show();


    }


    private void setupTabs() {

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec spec = tabHost.newTabSpec("tag1");
        spec.setIndicator("Home");
        spec.setContent(R.id.tabHomeID);
        tabHost.addTab(spec);
        spec = tabHost.newTabSpec("tag2");
        spec.setIndicator("Sportbook");
        spec.setContent(R.id.tabSportsbookID);
        tabHost.addTab(spec);
        spec = tabHost.newTabSpec("tag2");
        spec.setIndicator("Rating");
        spec.setContent(R.id.tabRatingID);
        tabHost.addTab(spec);

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {

            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#ffffff"));


        }


    }

    private void prepareListDataForHomeTab() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding child data
        listDataHeader.add(app.getAllHeaders().get(0));
        listDataHeader.add(app.getAllHeaders().get(1));


        // Adding child data
        List<String> topSportsBooks = new ArrayList<String>();
        topSportsBooks.addAll(app.getAllNeededNames());


        List<String> bestBonuses = new ArrayList<String>();
        bestBonuses.addAll(app.getAllPromotions());


        List<String> subItems1 = new ArrayList<String>();
        subItems1.addAll(app.getAllCatchPhrases());

        List<String> subItems2 = new ArrayList<String>();
        subItems2.addAll(app.getAllPromotionsDetails());


        listDataChild.put(listDataHeader.get(0), topSportsBooks); // Header, Child data


        listDataChild.put(listDataHeader.get(1), bestBonuses);


    }


    private void displaySportsBookTabListview() {


        tabHost.setCurrentTabByTag("tag2");
        listViewForSportsBookTab = (ListView) findViewById(R.id.sportsBookTabListViewID);
        listViewForSportsBookTab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {


                    default:


                        Intent intent = new Intent(getApplicationContext(), WebView_activity.class);
                        startActivity(intent);

                        break;


                }


            }
        });
        SportsBookTabListAdapter sportsBookTabListAdapter = new SportsBookTabListAdapter(this, app.getAllSportsBookTabNames());
        listViewForSportsBookTab.setAdapter(sportsBookTabListAdapter);


    }

    private void displayRatingsTabListview() {


        tabHost.setCurrentTabByTag("tag3");
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, app.getAllSportsBookTabWebSitesURLS());
        listviewForRatingsTab.setAdapter(adapter);

    }


}
