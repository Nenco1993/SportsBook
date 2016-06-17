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
    MyApplication appObject;
    //MyApplication appAll;
    private String i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, header1, header2;
    List<String> ids = new ArrayList<String>();
    public static List<String> newNames = new ArrayList<String>();
    List<String> headeri = new ArrayList<String>();

    public static List<MyApplication> listOfCatches=new ArrayList<MyApplication>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_new);


        // appAll= (MyApplication) getApplication();


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


                           /* List<MyApplication> oldList=parseXML();

                            for (MyApplication app2:oldList){


                              newList.add(app2);



                            }*/


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

        // List<MyApplication> listOfAllStuff = new ArrayList<MyApplication>();


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





                       /* if (tagname.equals("section") && myparser.getAttributeName(0).equals("sectionType")) {


                            String atrValue = myparser.getAttributeValue(0);

                            app.setSectionType(atrValue);


                        }

                        if (tagname.equals("tinyImage ")) {

                            String logo = getText;
                            app.setLogo(logo);


                        }*/


                        break;

                    case XmlPullParser.TEXT:


                        getText = myparser.getText();


                        break;

                    case XmlPullParser.END_TAG:

                      /*  if (tagname.equals("name")) {


                            String name = getText;


                            app.setNames(name);


                        }

                        if (tagname.equals("sportBookID")) {

                            String ids = getText;

                            app.setIds(ids);


                        }*/

                        if (tagname.equals("catchPhrase")) {


                            String catchphrase = getText;

                            appObject.getListOfAllCatches().add(catchphrase);









                            // newList.add(catchphrase);


                        }

                      /*  if (tagname.equals("promotion")) {


                            String promotion = getText;
                            app.setPromotion(promotion);


                        }

                        if (tagname.equals("promotionDetails")) {

                            String promotiondetails = getText;
                            app.setPromotionDetails(promotiondetails);
                            //   System.out.println("                ALL THE PROMOTION DETAILS: " + app.getPromotionDetails());


                        }*/

                        //  listOfAllStuff.add(app);


                        // homeTab.setListOfSections(listOfSections);
                        // listOfHomeTab.add(app);



                        // newList.add(appObject);


                        break;
                }
                event = myparser.next();
            }

            stream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        // return listOfAllStuff;
    }

 /*   private void afterParse() {


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
            System.out.println();
            header1 = app.getNames().get(0);
            header2 = app.getNames().get(1);


        }


        newNames.remove("Top Sportsbooks");
        newNames.remove("Best Bonuses");
        headeri.clear();
        headeri.add(header1);
        headeri.add(header2);


    }*/


}
