package com.example.neven.sportsbooks_v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import dataFromServer.MyApplication;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SplashScreenNew extends AppCompatActivity {


    private String urlString = "http://www.eclecticasoft.com/appdata/ec01000220/sportsBooks.xml";
    private MyApplication db;
    private String i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, header1, header2;
    private List<String> ids = new ArrayList<String>();
    private List<String> newNames = new ArrayList<String>();
    private List<String> headeri = new ArrayList<String>();
    private List<String> listOfCatches = new ArrayList<String>();
    private List<String> listOfSectionTypes = new ArrayList<String>();
    private List<String> listOfAllTinyImages = new ArrayList<String>();
    private List<String> listOfNames = new ArrayList<String>();
    private List<String> listOfIDS = new ArrayList<String>();
    private List<String> listOfPromotions = new ArrayList<String>();
    private List<String> listOfPromotionDetails = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_new);

        db = (MyApplication) getApplication();


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();


        try {


            if (activeNetwork.isConnectedOrConnecting()) {


                final ProgressDialog progressDialog = ProgressDialog.show(this, "Please wait...", "Downloading data from web", true);


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {

                            parseXML();
                            afterParse();


                        } catch (Exception e) {

                            e.printStackTrace();
                        }

                        progressDialog.dismiss();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();


                    }
                }).start();


            } else {

                Toast.makeText(SplashScreenNew.this, "Internet connection must be ON", Toast.LENGTH_LONG).show();
                finishAffinity();


            }


        } catch (Exception e) {


            Toast.makeText(SplashScreenNew.this, "Internet connection must be ON", Toast.LENGTH_LONG).show();
            finishAffinity();


        }


    }


    public void parseXML() {


        int event;


        String getText = null;


        try {


            //__________________dohvati_________
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(10000);
            conn.setConnectTimeout(1500000000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            InputStream stream = conn.getInputStream();
            XmlPullParserFactory xmlFactoryObject;
            XmlPullParser myparser;

            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myparser = xmlFactoryObject.newPullParser();


            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(stream, null);

            //_____________________________


            event = myparser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {

                String tagname = myparser.getName();


                switch (event) {
                    case XmlPullParser.START_TAG:


                        if (tagname.equals("section") && myparser.getAttributeName(0).equals("sectionType")) {


                            String atrValue = myparser.getAttributeValue(0);

                            listOfSectionTypes.add(atrValue);

                            db.setAllSectionTypes(listOfSectionTypes);


                        }




                        break;

                    case XmlPullParser.TEXT:


                        getText = myparser.getText();


                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equals("name")) {


                            String name = getText;
                            listOfNames.add(name);
                            db.setAllNames(listOfNames);


                        }

                        if (tagname.equals("sportBookID")) {

                            String ids = getText;
                            listOfIDS.add(ids);
                            db.setAllids(listOfIDS);


                        }

                        if (tagname.equals("catchPhrase")) {


                            String catchphrase = getText;
                            listOfCatches.add(catchphrase);
                            db.setAllCatchPhrases(listOfCatches);


                        }

                        if (tagname.equals("promotion")) {


                            String promotion = getText;
                            listOfPromotions.add(promotion);
                            db.setAllPromotions(listOfPromotions);


                        }

                        if (tagname.equals("promotionDetails")) {

                            String promotiondetails = getText;
                            listOfPromotionDetails.add(promotiondetails);
                            db.setAllPromotionsDetails(listOfPromotionDetails);


                        }

                        if (tagname.equals("tinyImage")) {

                            String tinyimage = getText;
                            listOfAllTinyImages.add(tinyimage);
                            db.setAllTinyImages(listOfAllTinyImages);


                        }


                        break;
                }
                event = myparser.next();
            }

            stream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void afterParse() {


        for (String s : db.getAllids()) {


            i0 = db.getAllids().get(0);
            i1 = db.getAllids().get(1);
            i2 = db.getAllids().get(2);
            i3 = db.getAllids().get(3);
            i4 = db.getAllids().get(4);
            i5 = db.getAllids().get(5);
            i6 = db.getAllids().get(6);
            i7 = db.getAllids().get(7);
            i8 = db.getAllids().get(8);
            i9 = db.getAllids().get(9);


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
        db.setAllNeededIds(ids);


        for (String s2 : db.getAllNames()) {


            newNames.add(s2);

            header1 = db.getAllNames().get(0);
            header2 = db.getAllNames().get(1);


        }


        newNames.remove("Top Sportsbooks");
        newNames.remove("Best Bonuses");
        db.setAllNeededNames(newNames);
        headeri.clear();
        headeri.add(header1);
        headeri.add(header2);
        db.setAllHeaders(headeri);


    }


}
