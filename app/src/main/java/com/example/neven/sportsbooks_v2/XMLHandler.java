package com.example.neven.sportsbooks_v2;


import dataFromServer.AllSportsBooks;
import dataFromServer.HomeTab;
import org.xmlpull.v1.XmlPullParser;

import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Neven on 12.6.2016..
 */
public class XMLHandler {

    List<String> catchphrase2 = new ArrayList<String>();

    public List<String> getCatchphrase2() {
        return catchphrase2;
    }

    public void setCatchphrase2(List<String> catchphrase2) {
        this.catchphrase2 = catchphrase2;
    }

    private String urlString = null;
    private AllSportsBooks allSportsBooks;
    private HomeTab homeTab;
    private HomeTab.Section section;
    private List<HomeTab.Section> listOfSections;
    public static List<String> listOfSportBookIDS = new ArrayList<String>();
    public static List<String> listOfSportBookNames = new ArrayList<String>();
    public static HashMap<String, List<String>> listOfSportBookNamesHashMap;
    public static List<String> listOfCatchPhrases = new ArrayList<String>();
    public static List<String> listOfPromotions = new ArrayList<String>();
    public static List<String> listOfPromotionsDetails = new ArrayList<String>();
    public static List<String> listOFLogos = new ArrayList<String>();


    public XMLHandler(String urlString) {
        this.urlString = urlString;
    }

    public List<HomeTab.Section> parseHomeTab() {

        List<HomeTab.Section> listOfHomeTab = new ArrayList<HomeTab.Section>();


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


                            homeTab = new HomeTab();

                            listOfSections = new ArrayList<HomeTab.Section>();


                        }

                        if (tagname.equals("section") && myparser.getAttributeName(0).equals("sectionType")) {


                            section = new HomeTab.Section();

                            String atrValue = myparser.getAttributeValue(0);

                            section.setSectionType(atrValue);


                        }

                        if (tagname.equals("tinyImage ")) {

                            String logo = getText;
                            listOFLogos.add(logo);


                        }


                        break;

                    case XmlPullParser.TEXT:


                        getText = myparser.getText();


                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equals("name")) {


                            String name = getText;


                            listOfSportBookNames.add(name);


                            section.setName(name);


                        }

                        if (tagname.equals("sportBookID")) {

                            String ids = getText;
                            listOfSportBookIDS.add(ids);


                        }

                        if (tagname.equals("catchPhrase")) {


                            String catchphrase = getText;

                            listOfCatchPhrases.add(catchphrase);


                        }

                        if (tagname.equals("promotion")) {

                            AllSportsBooks books = new AllSportsBooks();

                            String promotion = getText;
                            books.setPromotion(promotion);
                            listOfPromotions.add(promotion);


                        }

                        if (tagname.equals("promotionDetails")) {

                            String promotiondetails = getText;
                            listOfPromotionsDetails.add(promotiondetails);


                        }


                        homeTab.setListOfSections(listOfSections);


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
