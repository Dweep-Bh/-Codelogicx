package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Show extends AppCompatActivity {
  TextView tv1;
  Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        tv1=findViewById(R.id.tv1);
        btnBack=findViewById(R.id.btnback);
        String val= getIntent().getExtras().getString("key");
        tv1.setText(val);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Show.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }
}