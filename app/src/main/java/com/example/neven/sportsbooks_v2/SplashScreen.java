package com.example.neven.sportsbooks_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neven on 15.6.2016..
 */
public class SplashScreen extends Activity {

  /*  private XMLHandler objectXMLhandler;
    public List<HomeTab.Section> randomList;
    public static List<String> names = new ArrayList<String>();
    public static List<String> headers = new ArrayList<String>();
    private List<String> ids = new ArrayList<String>();
    private ArrayList<HomeTab.Section> newList = new ArrayList<HomeTab.Section>();
    private String url = "http://www.eclecticasoft.com/appdata/ec01000220/sportsBooks.xml";
    private String i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, header1, header2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen_layout);

        pocetniScreen();


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {


                    objectXMLhandler = new XMLHandler(url);

                    randomList = objectXMLhandler.parseHomeTab();
                    afterParse();

                    for (HomeTab.Section ht : randomList) {


                        newList.add(ht);


                    }


                } catch (Exception e) {

                    e.printStackTrace();
                }


            }
        }).start();


    }


    private void pocetniScreen() {

        Thread tajmer = new Thread() {

            public void run() {

                try {

                    sleep(3000);


                } catch (InterruptedException e) {


                    e.printStackTrace();
                } finally {


                    Intent go = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(go);
                    finish();


                }


            }


        };

        tajmer.start();


    }

    private void afterParse() {


        for (String s : XMLHandler.listOfSportBookIDS) {


            i0 = XMLHandler.listOfSportBookIDS.get(0);
            i1 = XMLHandler.listOfSportBookIDS.get(1);
            i2 = XMLHandler.listOfSportBookIDS.get(2);
            i3 = XMLHandler.listOfSportBookIDS.get(3);
            i4 = XMLHandler.listOfSportBookIDS.get(4);
            i5 = XMLHandler.listOfSportBookIDS.get(5);
            i6 = XMLHandler.listOfSportBookIDS.get(6);
            i7 = XMLHandler.listOfSportBookIDS.get(7);
            i8 = XMLHandler.listOfSportBookIDS.get(8);
            i9 = XMLHandler.listOfSportBookIDS.get(9);


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


        for (String s2 : XMLHandler.listOfSportBookNames) {


            names.add(s2);
            header1 = XMLHandler.listOfSportBookNames.get(0);
            header2 = XMLHandler.listOfSportBookNames.get(1);


        }


        names.remove("Top Sportsbooks");
        names.remove("Best Bonuses");
        headers.clear();
        headers.add(header1);
        headers.add(header2);


    }*/


}
