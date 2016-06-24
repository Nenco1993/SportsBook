package com.example.neven.sportsbooks_v2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import dataFromServer.MyApplication;

public class WebView_for_promotions_tab extends AppCompatActivity {

    WebView browser;
    MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_web_view_for_promotions_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        browser = (WebView) findViewById(R.id.webviewForPromotionsTabID);
        browser.setWebViewClient(new MyBrowser());


        app = (MyApplication) getApplication();

        Bundle getArgsForPromotionsTab = getIntent().getExtras();
        String argsForPromotionsTab = getArgsForPromotionsTab.getString("promotion");

        if (argsForPromotionsTab.equals("zero")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(0));



        }else if (argsForPromotionsTab.equals("one")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(1));



        }else if (argsForPromotionsTab.equals("two")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(5));



        }else if (argsForPromotionsTab.equals("three")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(8));



        }else if (argsForPromotionsTab.equals("four")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(9));



        }else if (argsForPromotionsTab.equals("five")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(11));




        }else if (argsForPromotionsTab.equals("six")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(12));



        }else if (argsForPromotionsTab.equals("seven")){

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(13));



        }


    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
