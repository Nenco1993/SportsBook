package com.example.neven.sportsbooks_v2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.*;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import dataFromServer.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyApplication app;

    private String i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, header1, header2;
    List<String> ids=new ArrayList<String>();
    List<String> newNames=new ArrayList<String>();
    List<String> headeri=new ArrayList<String>();

    private TabHost tabHost;
    private ExpandableListView expandableListView;
    private ImageView ivLogo;
    private ListView listView;
    private ListView listView2;


    private ImageView slika;
    private ImageView slika2;
    private ImageView slika3;
    private ImageView slika4;


    private HashMap<String, List<String>> childData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        afterParse();

        app = (MyApplication) getApplication();


        ivLogo = (ImageView) findViewById(R.id.ivLogoID);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView); //privremeno gone
        listView = (ListView) findViewById(R.id.listView);
        listView2 = (ListView) findViewById(R.id.listView2);
        slika = (ImageView) findViewById(R.id.imageView);
        slika2 = (ImageView) findViewById(R.id.imageView2);
        slika3 = (ImageView) findViewById(R.id.imageView3);
        slika4 = (ImageView) findViewById(R.id.imageView4);


         listviewIspis();


        setupTabs();


        //______________________________library za prikazivanje slika____________________________________

        ImageLoaderConfiguration cfg = ImageLoaderConfiguration.createDefault(getApplicationContext());


        ImageLoader imageLoader = ImageLoader.getInstance();
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


        // prepareListData();

        //Custom_listview adapter = new Custom_listview(getApplicationContext(), headerData, childData);

        // expandableListView.setAdapter(adapter);


        Toast.makeText(MainActivity.this, "podaci dohvaceni", Toast.LENGTH_LONG).show();


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

    private void prepareListData() {

        List<String> headerData = new ArrayList<String>();
        //headerData.addAll(headers);
        childData = new HashMap<String, List<String>>();


        //headerData.add(headers.get(0));
        // headerData.add(headers.get(1));


        // Adding child data
        List<String> firstSectionNames = new ArrayList<String>();
        firstSectionNames.add("The Shawshank Redemption");
        firstSectionNames.add("The Godfather");
        firstSectionNames.add("The Godfather: Part II");
        firstSectionNames.add("Pulp Fiction");
        firstSectionNames.add("The Good, the Bad and the Ugly");
        firstSectionNames.add("The Dark Knight");
        firstSectionNames.add("12 Angry Men");

        List<String> secondSectionNames = new ArrayList<String>();
        secondSectionNames.add("The Conjuring");
        secondSectionNames.add("Despicable Me 2");
        secondSectionNames.add("Turbo");
        secondSectionNames.add("Grown Ups 2");
        secondSectionNames.add("Red 2");
        secondSectionNames.add("The Wolverine");


        childData.put(headerData.get(0), firstSectionNames); // Header, Child data
        childData.put(headerData.get(1), secondSectionNames);

    }

    private void listviewIspis() {

        ListAdapter la = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, app.getNames());
        listView.setAdapter(la);


    }

    private void afterParse() {


        for (String s : app.getIds()) {


            i0 = app.getIds().get(0);
            i1 = app.getIds().get(1);
            i2 = app.getIds().get(2);
            i3 = app.getIds().get(3);
            i4 = app.getIds().get(4);
            i5 = app.getIds().get(5);
            i6 = app.getIds().get(6);
            i7 = app.getIds().get(7);
            i8 = app.getIds().get(8);
            i9 = app.getIds().get(9);


        }


        ids.add(i0);
        ids.add(i1);
        ids.add(i2);
        ids.add(i3);
        ids.add(i4);
        ids.add(i5);
        ids.add(i6);
        ids.add(i7);
        ids.add(i8);
        ids.add(i9);


        for (String s2 : app.getNames()) {


            newNames.add(s2);
            header1 = app.getNames().get(0);
            header2 = app.getNames().get(1);


        }


        newNames.remove("Top Sportsbooks");
        newNames.remove("Best Bonuses");
        headeri.clear();
        headeri.add(header1);
        headeri.add(header2);




    }


}
