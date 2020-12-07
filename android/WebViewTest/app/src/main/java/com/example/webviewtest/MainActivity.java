package com.example.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.loadUrl("https://www.naver.com");

        WebBtnClickListener webBtnClickListener = new WebBtnClickListener();
        button1.setOnClickListener(webBtnClickListener);
        button2.setOnClickListener(webBtnClickListener);
        button3.setOnClickListener(webBtnClickListener);

    }

    class WebBtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if( id == R.id.button1) {
                webView.loadUrl("https://www.daum.net");
            }
            else if (id == R.id.button2) {
                webView.loadUrl("https://www.google.com");
            }
            else {
                webView.loadUrl("https://developer.android.com");
            }
        }
    }
}