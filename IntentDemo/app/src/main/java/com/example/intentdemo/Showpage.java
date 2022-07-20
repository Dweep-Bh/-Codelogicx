package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showpage extends AppCompatActivity {

    TextView tv1,tv2,tvphonenumber;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpage);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        bt1=findViewById(R.id.bt1);
        tvphonenumber=findViewById(R.id.tvphonenumber);
        String val= getIntent().getExtras().getString("Key");
        String val1= getIntent().getExtras().getString("Ph");
        tv2.setText(val);
        tvphonenumber.setText(val1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj= new Intent(Showpage.this,MainActivity.class);

                startActivity(obj);

            }
        });
    }
}