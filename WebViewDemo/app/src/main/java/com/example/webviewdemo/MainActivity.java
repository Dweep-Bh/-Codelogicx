package com.example.webviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wb=findViewById(R.id.wb);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("http://medihunt.co.in/login.php");
    }
}