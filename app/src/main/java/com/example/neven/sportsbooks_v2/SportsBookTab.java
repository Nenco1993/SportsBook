package com.example.neven.sportsbooks_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import dataFromServer.MyApplication;

public class SportsBookTab extends AppCompatActivity {


    MyApplication app;
    ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sportsbook_tab);

        ImageView ivScreenshot = (ImageView) findViewById(R.id.ivScreenshotID);
        TextView tvReview = (TextView) findViewById(R.id.tvReviewID);


        app = (MyApplication) getApplication();

        Bundle getArgs = getIntent().getExtras();
        String args = getArgs.getString("key1");

        if (args.equals("betdsi")) {


            tvReview.setText(app.getListOfAllReviews().get(0));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(0), ivScreenshot);


        } else if (args.equals("bookmaker")) {


            tvReview.setText(app.getListOfAllReviews().get(1));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(1), ivScreenshot);


        } else if (args.equals("bovada")) {


            tvReview.setText(app.getListOfAllReviews().get(5));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(5), ivScreenshot);


        } else if (args.equals("gtbets")) {


            tvReview.setText(app.getListOfAllReviews().get(8));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(8), ivScreenshot);


        } else if (args.equals("betonline")) {


            tvReview.setText(app.getListOfAllReviews().get(9));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(9), ivScreenshot);


        } else if (args.equals("mybookie")) {


            tvReview.setText(app.getListOfAllReviews().get(11));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(11), ivScreenshot);


        } else if (args.equals("topbet")) {


            tvReview.setText(app.getListOfAllReviews().get(12));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(12), ivScreenshot);


        } else if (args.equals("sportsbetting")) {


            tvReview.setText(app.getListOfAllReviews().get(13));
            imageLoader.displayImage(app.getListOfAllScreenshotImages().get(13), ivScreenshot);


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
