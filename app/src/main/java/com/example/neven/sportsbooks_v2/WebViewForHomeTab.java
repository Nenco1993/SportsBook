package com.example.neven.sportsbooks_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import dataFromServer.MyApplication;

public class WebViewForHomeTab extends AppCompatActivity {

    WebView browser;
    MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_web_view_for_home_tab);

        browser = (WebView) findViewById(R.id.webView2);
        browser.setWebViewClient(new MyBrowser());


        app = (MyApplication) getApplication();

        Bundle getArgs2 = getIntent().getExtras();
        String args2 = getArgs2.getString("key2");

        if (args2.equals("zero1")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(0));


        } else if (args2.equals("one1")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(1));


        } else if (args2.equals("two1")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(5));


        } else if (args2.equals("three1")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(9));


        } else if (args2.equals("four1")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(11));


        }else if (args2.equals("zero2")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(0));


        }else if (args2.equals("one2")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(1));


        }else if (args2.equals("two2")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(8));


        }else if (args2.equals("three2")) {

            browser.loadUrl(app.getAllSportsBookTabWebSitesURLS().get(12));


        }else if (args2.equals("four2")) {

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
