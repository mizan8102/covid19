package com.bangladesh.covid19bd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Govt_web extends AppCompatActivity {
WebView web;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_web);
        getSupportActionBar().setTitle("Govt Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        web=(WebView)findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient() {

            // This method will be triggered when the Page Started Loading

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog = ProgressDialog.show(Govt_web.this, null,
                        "Please wait...");
                dialog.setCancelable(true);
                super.onPageStarted(view, url, favicon);
            }

            // This method will be triggered when the Page loading is completed

            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
                super.onPageFinished(view, url);
            }

            // This method will be triggered when error page appear

            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                dialog.dismiss();
                // You can redirect to your own page instead getting the default
                // error page
                Toast.makeText(Govt_web.this,
                        "The Requested Page Does Not Exist", Toast.LENGTH_LONG).show();
                web.loadUrl("https://corona.gov.bd/");
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        web.loadUrl("https://corona.gov.bd/");
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
    }
}
