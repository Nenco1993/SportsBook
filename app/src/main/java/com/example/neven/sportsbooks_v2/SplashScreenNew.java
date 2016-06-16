package com.example.neven.sportsbooks_v2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
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
    MyApplication app;
    List<MyApplication> someList = new ArrayList<MyApplication>();
    List<MyApplication> newList = new ArrayList<MyApplication>();
    public static List<String>listofcatch;


    private String i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, header1, header2;
    List<String> ids = new ArrayList<String>();
    public static List<String> newNames = new ArrayList<String>();
    List<String> headeri = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_new);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);




        app = (MyApplication) getApplication();

        final ProgressDialog progressDialog = ProgressDialog.show(this, "Please wait...", "Downloading data from web", true);


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    newList.clear();
                    someList = parseXML();
                   // afterParse();




                    for (MyApplication appObject : someList) {


                        newList.add(appObject);


                    }


                } catch (Exception e) {

                    e.printStackTrace();
                }

                progressDialog.dismiss();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        }).start();





    }


    public List<MyApplication> parseXML() {

        List<MyApplication> listOfHomeTab = new ArrayList<MyApplication>();


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


                        if (tagname.equals("homeTab")) {


                            // listOfSections = new ArrayList<HomeTab.Section>();


                        }

                        if (tagname.equals("section") && myparser.getAttributeName(0).equals("sectionType")) {


                            //section = new HomeTab.Section();

                            String atrValue = myparser.getAttributeValue(0);

                            app.setSectionType(atrValue);


                        }

                        if (tagname.equals("tinyImage ")) {

                            String logo = getText;
                            app.setLogo(logo);


                        }


                        break;

                    case XmlPullParser.TEXT:


                        getText = myparser.getText();


                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equals("name")) {


                            String name = getText;
                          //  System.out.println("#!#!#!#!#!#!###!#!#!#!#!*#!*##*!#!*#*!#!*: "+name);
                            List<String> listaImena = new ArrayList<String>();
                            listaImena.add(name);
                            app.setNames(listaImena);
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "+app.getNames());


                        }

                        if (tagname.equals("sportBookID")) {

                            String ids = getText;
                            List<String> idevi = new ArrayList<String>();
                            idevi.add(ids);
                            app.setIds(idevi);


                        }

                        if (tagname.equals("catchPhrase")) {


                            String catchphrase = getText;

                            listofcatch=new ArrayList<String>();
                            listofcatch.add(catchphrase);

                            System.out.println("ALL THE CATCHPHRASES: "+catchphrase);

                            app.setCatchPhrase(listofcatch);


                        }

                        if (tagname.equals("promotion")) {


                            String promotion = getText;
                            app.setPromotion(promotion);


                        }

                        if (tagname.equals("promotionDetails")) {

                            String promotiondetails = getText;
                            app.setPromotionDetails(promotiondetails);
                            System.out.println("ALL THE PROMOTION DETAILS: "+app.getPromotionDetails());


                        }


                        // homeTab.setListOfSections(listOfSections);


                        break;
                }
                event = myparser.next();
            }

            stream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfHomeTab;
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


    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
