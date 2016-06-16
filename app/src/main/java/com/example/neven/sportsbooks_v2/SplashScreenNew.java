package com.example.neven.sportsbooks_v2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import dataFromServer.MyApplication;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SplashScreenNew extends AppCompatActivity {


    private String urlString = null;
    private String url = "http://www.eclecticasoft.com/appdata/ec01000220/sportsBooks.xml";
    MyApplication app;
    List<MyApplication> someList = new ArrayList<MyApplication>();
    List<MyApplication> newList = new ArrayList<MyApplication>();

    public SplashScreenNew(String urlString) {
        this.urlString = urlString;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_new);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        app = (MyApplication) getApplication();


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    SplashScreenNew object = new SplashScreenNew(url);

                    someList = object.parseXML();


                    for (MyApplication appObject : someList) {


                        newList.add(appObject);


                    }


                } catch (Exception e) {

                    e.printStackTrace();
                }


            }
        }).start();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);


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
                            List<String> listaImena = new ArrayList<String>();
                            listaImena.add(name);
                            app.setNames(listaImena);


                        }

                        if (tagname.equals("sportBookID")) {

                            String ids = getText;
                            List<String> idevi = new ArrayList<String>();
                            idevi.add(ids);
                            app.setIds(idevi);


                        }

                        if (tagname.equals("catchPhrase")) {


                            String catchphrase = getText;

                            app.setCatchPhrase(catchphrase);


                        }

                        if (tagname.equals("promotion")) {


                            String promotion = getText;
                            app.setPromotion(promotion);


                        }

                        if (tagname.equals("promotionDetails")) {

                            String promotiondetails = getText;
                            app.setPromotionDetails(promotiondetails);


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


}
