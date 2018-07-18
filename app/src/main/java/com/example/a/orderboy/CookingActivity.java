package com.example.a.orderboy;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CookingActivity extends Activity {
    private WebView m1webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);

        m1webview = (WebView) findViewById(R.id.webView);        // Enable Javascript

        WebSettings webSettings1 = m1webview.getSettings();
        webSettings1.setJavaScriptEnabled(true);

        m1webview.loadUrl("https://youtu.be/z4sN05-xIs4");

        finish();
    }


}
