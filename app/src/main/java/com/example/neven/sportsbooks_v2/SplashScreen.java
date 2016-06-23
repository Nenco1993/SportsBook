package com.example.neven.sportsbooks_v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import dataFromServer.MyApplication;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {


    private String urlString = "http://www.eclecticasoft.com/appdata/ec01000220/sportsBooks.xml";
    private MyApplication db;
    private String i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, header1, header2;
    private List<String> ids = new ArrayList<String>();
    private List<String> allNamesWithoutHeaders = new ArrayList<String>();
    private List<String> headeri = new ArrayList<String>();
    private List<String> listOfCatches = new ArrayList<String>();
    private List<String> listOfSectionTypes = new ArrayList<String>();
    private List<String> listOfAllTinyImages = new ArrayList<String>();
    private List<String> listOfNames = new ArrayList<String>();
    private List<String> listOfIDS = new ArrayList<String>();
    private List<String> listOfPromotions = new ArrayList<String>();
    private List<String> listOfPromotionDetails = new ArrayList<String>();
    private List<String> listOfSportsBookTabNames = new ArrayList<String>();
    private List<String> listOfSportsBookTabLogos = new ArrayList<String>();
    private List<String> listOfAllWebSitesURLS = new ArrayList<String>();
    private List<String> listOfFirstSectionNames = new ArrayList<String>();
    private List<String> listOfSecondSectionNames = new ArrayList<String>();

    private List<String> listOfFirstSectionNamesNeeded = new ArrayList<String>();
    private List<String> listOfSecondSectionNamesNeeded = new ArrayList<String>();

    private List<String> listOfFirstSectionHomeTabLogos = new ArrayList<String>();
    private List<String> listOfSecondSectionHomeTabLogos = new ArrayList<String>();
    private List<String> listOfFirstSectionHomeTabLogosNeeded = new ArrayList<String>();
    private List<String> listOfSecondSectionHomeTabLogosNeeded = new ArrayList<String>();
    private List<String> allLogosOnOnePlace = new ArrayList<String>();
    private List<String> listOfAllCatchesForFirstSection = new ArrayList<String>();
    private List<String> listOfAllCatchesForFirstSectionNeeded = new ArrayList<String>();
    private List<String> listOfAllPromotionsDetailsForSecondSection = new ArrayList<String>();
    private List<String> listOfAllPromotionsDetailsForSecondSectionNeeded = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

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

                Toast.makeText(SplashScreen.this, "Internet connection must be ON", Toast.LENGTH_LONG).show();
                finishAffinity();


            }


        } catch (Exception e) {


            Toast.makeText(SplashScreen.this, "Internet connection must be ON", Toast.LENGTH_LONG).show();
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

                        if (tagname.equals("url")) {


                            String link = getText;
                            listOfAllWebSitesURLS.add(link);
                            db.setAllSportsBookTabWebSitesURLS(listOfAllWebSitesURLS);


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

        for (String s10:db.getAllPromotionsDetails()){

            listOfAllPromotionsDetailsForSecondSection.add(s10);






        }

        listOfAllPromotionsDetailsForSecondSectionNeeded.add(listOfAllPromotionsDetailsForSecondSection.get(0));
        listOfAllPromotionsDetailsForSecondSectionNeeded.add(listOfAllPromotionsDetailsForSecondSection.get(1));
        listOfAllPromotionsDetailsForSecondSectionNeeded.add(listOfAllPromotionsDetailsForSecondSection.get(8));
        listOfAllPromotionsDetailsForSecondSectionNeeded.add(listOfAllPromotionsDetailsForSecondSection.get(12));
        listOfAllPromotionsDetailsForSecondSectionNeeded.add(listOfAllPromotionsDetailsForSecondSection.get(13));

        db.setAllPromotionsDetailsForSecondSection(listOfAllPromotionsDetailsForSecondSectionNeeded);




        for (String s8:db.getAllCatchPhrases()){

            listOfAllCatchesForFirstSection.add(s8);




        }

        listOfAllCatchesForFirstSectionNeeded.add(listOfAllCatchesForFirstSection.get(0));
        listOfAllCatchesForFirstSectionNeeded.add(listOfAllCatchesForFirstSection.get(1));
        listOfAllCatchesForFirstSectionNeeded.add(listOfAllCatchesForFirstSection.get(5));
        listOfAllCatchesForFirstSectionNeeded.add(listOfAllCatchesForFirstSection.get(9));
        listOfAllCatchesForFirstSectionNeeded.add(listOfAllCatchesForFirstSection.get(11));
        db.setAllCatchesForFirstSection(listOfAllCatchesForFirstSectionNeeded);



        for (String s7 : db.getAllPromotions()) {

            listOfSecondSectionNames.add(s7);


        }

        listOfSecondSectionNamesNeeded.add(listOfSecondSectionNames.get(0));
        listOfSecondSectionNamesNeeded.add(listOfSecondSectionNames.get(1));
        listOfSecondSectionNamesNeeded.add(listOfSecondSectionNames.get(8));
        listOfSecondSectionNamesNeeded.add(listOfSecondSectionNames.get(12));
        listOfSecondSectionNamesNeeded.add(listOfSecondSectionNames.get(13));
        db.setListOfAllHomeTabSecondSectionPromotions(listOfSecondSectionNamesNeeded);


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

        for (String s3 : db.getAllTinyImages()) {

            listOfSportsBookTabLogos.add(s3);
            listOfFirstSectionHomeTabLogos.add(s3);
            listOfSecondSectionHomeTabLogos.add(s3);


        }


        listOfFirstSectionHomeTabLogosNeeded.add(listOfFirstSectionHomeTabLogos.get(0));
        listOfFirstSectionHomeTabLogosNeeded.add(listOfFirstSectionHomeTabLogos.get(1));
        listOfFirstSectionHomeTabLogosNeeded.add(listOfFirstSectionHomeTabLogos.get(5));
        listOfFirstSectionHomeTabLogosNeeded.add(listOfFirstSectionHomeTabLogos.get(9));
        listOfFirstSectionHomeTabLogosNeeded.add(listOfFirstSectionHomeTabLogos.get(11));
        db.setListOfAllHomeTabFirstSectionLogos(listOfFirstSectionHomeTabLogosNeeded);

        listOfSecondSectionHomeTabLogosNeeded.add(listOfSecondSectionHomeTabLogos.get(0));
        listOfSecondSectionHomeTabLogosNeeded.add(listOfSecondSectionHomeTabLogos.get(1));
        listOfSecondSectionHomeTabLogosNeeded.add(listOfSecondSectionHomeTabLogos.get(8));
        listOfSecondSectionHomeTabLogosNeeded.add(listOfSecondSectionHomeTabLogos.get(12));
        listOfSecondSectionHomeTabLogosNeeded.add(listOfSecondSectionHomeTabLogos.get(13));
        db.setListOfAllHomeTabSecondSectionLogos(listOfSecondSectionHomeTabLogosNeeded);

        allLogosOnOnePlace.add(listOfFirstSectionHomeTabLogos.get(0));
        allLogosOnOnePlace.add(listOfFirstSectionHomeTabLogos.get(1));
        allLogosOnOnePlace.add(listOfFirstSectionHomeTabLogos.get(5));
        allLogosOnOnePlace.add(listOfFirstSectionHomeTabLogos.get(9));
        allLogosOnOnePlace.add(listOfFirstSectionHomeTabLogos.get(11));

        allLogosOnOnePlace.add(listOfSecondSectionHomeTabLogos.get(0));
        allLogosOnOnePlace.add(listOfSecondSectionHomeTabLogos.get(1));
        allLogosOnOnePlace.add(listOfSecondSectionHomeTabLogos.get(5));
        allLogosOnOnePlace.add(listOfSecondSectionHomeTabLogos.get(9));
        allLogosOnOnePlace.add(listOfSecondSectionHomeTabLogos.get(11));

        db.setAllLogosForHomeTab(allLogosOnOnePlace);


        listOfSportsBookTabLogos.remove("https://www.eclecticasoft.com/appdata/ec01000220/img/icon_21.png");
        listOfSportsBookTabLogos.remove("https://www.eclecticasoft.com/appdata/ec01000220/img/icon_22.png");
        listOfSportsBookTabLogos.remove("https://www.eclecticasoft.com/appdata/ec01000220/img/icon_23.png");
        listOfSportsBookTabLogos.remove("https://www.eclecticasoft.com/appdata/ec01000220/img/icon_25.png");
        listOfSportsBookTabLogos.remove("https://www.eclecticasoft.com/appdata/ec01000220/img/icon_26.png");
        listOfSportsBookTabLogos.remove("https://www.eclecticasoft.com/appdata/ec01000220/img/icon_31.png");
        listOfSportsBookTabLogos.remove("https://www.eclecticasoft.com/appdata/ec01000220/img/icon_35.png");


        db.setAllSportsBookTabLogos(listOfSportsBookTabLogos);


        for (String s2 : db.getAllNames()) {


            allNamesWithoutHeaders.add(s2);
            listOfSportsBookTabNames.add(s2);
            listOfFirstSectionNames.add(s2);


            header1 = db.getAllNames().get(0);
            header2 = db.getAllNames().get(1);


        }


        listOfSportsBookTabNames.remove("Top Sportsbooks");
        listOfSportsBookTabNames.remove("Best Bonuses");
        listOfSportsBookTabNames.remove("WagerWeb");
        listOfSportsBookTabNames.remove("JustBet");
        listOfSportsBookTabNames.remove("5Dimes");
        listOfSportsBookTabNames.remove("Sportbet");
        listOfSportsBookTabNames.remove("SportsBettingOnline");
        listOfSportsBookTabNames.remove("BetAnySports");
        listOfSportsBookTabNames.remove("Bet With The Best");
        listOfSportsBookTabNames.remove("BetOWI");

        db.setAllSportsBookTabNames(listOfSportsBookTabNames);


        allNamesWithoutHeaders.remove("Top Sportsbooks");
        allNamesWithoutHeaders.remove("Best Bonuses");
        db.setAllNeededNames(allNamesWithoutHeaders);


        listOfFirstSectionNamesNeeded.add(allNamesWithoutHeaders.get(0));
        listOfFirstSectionNamesNeeded.add(allNamesWithoutHeaders.get(1));
        listOfFirstSectionNamesNeeded.add(allNamesWithoutHeaders.get(5));
        listOfFirstSectionNamesNeeded.add(allNamesWithoutHeaders.get(9));
        listOfFirstSectionNamesNeeded.add(allNamesWithoutHeaders.get(11));
        db.setListOfAllHomeTabFirstSectionNames(listOfFirstSectionNamesNeeded);


        headeri.clear();
        headeri.add(header1);
        headeri.add(header2);
        db.setAllHeaders(headeri);


    }


}
