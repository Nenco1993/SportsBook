package com.example.neven.sportsbooks_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import dataFromServer.MyApplication;

public class WebView_for_ratings_tab extends AppCompatActivity {

    WebView browser;
    MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_web_view_for_ratings_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        browser = (WebView) findViewById(R.id.webViewForRatingsTab);

        browser.setWebViewClient(new MyBrowser());


        app = (MyApplication) getApplication();

        Bundle getArgsForRatingsTab = getIntent().getExtras();
        String argsForRatingsTab = getArgsForRatingsTab.getString("key3");

        if (argsForRatingsTab.equals("zero")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(0));


        } else if (argsForRatingsTab.equals("one")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(1));


        } else if (argsForRatingsTab.equals("two")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(5));


        } else if (argsForRatingsTab.equals("three")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(13));


        } else if (argsForRatingsTab.equals("four")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(9));


        } else if (argsForRatingsTab.equals("five")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(8));


        } else if (argsForRatingsTab.equals("six")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(12));


        } else if (argsForRatingsTab.equals("seven")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(11));


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
