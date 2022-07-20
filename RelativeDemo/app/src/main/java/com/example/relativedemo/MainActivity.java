package com.example.relativedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

     EditText username,password,phoneno,address;
     RadioButton rb1,rb2;
     Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        phoneno=findViewById(R.id.phoneno);
        address=findViewById(R.id.address);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        bt2=findViewById(R.id.bt2);

    }
}