package com.example.webtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        btnsearch=findViewById(R.id.btnsearch);
        String url="http://medihunt.co.in/login.php";
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1;
                s1=et1.getText().toString();
                Intent sp= new Intent(Intent.ACTION_VIEW);
                sp.setData(Uri.parse(url+s1));
                startActivity(sp);
            }
        });
    }
}