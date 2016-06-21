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
import android.widget.Toast;
import dataFromServer.MyApplication;

public class WebView_activity extends AppCompatActivity {

    WebView browser;
    MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_web_view_activity);

        browser = (WebView) findViewById(R.id.webView);
        browser.setWebViewClient(new MyBrowser());


        app = (MyApplication) getApplication();

        Bundle getArgs = getIntent().getExtras();
        String args = getArgs.getString("key1");

        if (args.equals("betdsi")) {


            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(0));


        } else if (args.equals("bookmaker")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(1));


        } else if (args.equals("bovada")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(5));


        } else if (args.equals("gtbets")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(8));


        } else if (args.equals("betonline")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(9));


        } else if (args.equals("mybookie")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(11));


        } else if (args.equals("topbet")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(12));


        } else if (args.equals("sportsbetting")) {

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
