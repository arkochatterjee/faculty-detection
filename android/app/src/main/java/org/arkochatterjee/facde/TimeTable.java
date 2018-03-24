package org.arkochatterjee.facde;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.sql.Time;

/**
 * Created by root on 24/3/18.
 */

public class TimeTable extends AppCompatActivity {

    ProgressDialog prDialog;
    WebView simpleWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.timetable);

        simpleWebView = (WebView) findViewById(R.id.webview);

        simpleWebView.setWebViewClient(new MyWebViewClient());

// string url which you have to load into a web view
        String url = "http://srmsce.com/facdehtml.html";

        simpleWebView.getSettings().setJavaScriptEnabled(true);
        simpleWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        simpleWebView.loadUrl(url); // load the url on the web view
    }

    // custom web view client class who extends WebViewClient
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url); // load the url
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            prDialog = new ProgressDialog(TimeTable.this);
            prDialog.setMessage("Please wait ...");
            //
            // prDialog.setCanceledOnTouchOutside();
            prDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (prDialog != null) {
                prDialog.dismiss();
            }
        }

    }

  /*  @Override
    public void onBackPressed()
    {
        if(simpleWebView.canGoBack()){
            simpleWebView.goBack();
        }else{
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit!")
                    .setMessage("Are you sure you want to close?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }*/
}
