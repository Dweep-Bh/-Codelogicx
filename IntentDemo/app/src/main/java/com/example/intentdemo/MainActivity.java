package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.transform.Source;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,etphonenumber;
    Button bt1,btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.bt1);
        btnsearch=findViewById(R.id.btnsearch);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        etphonenumber=findViewById(R.id.etphonenumber);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj1=new Intent(Intent.ACTION_VIEW);
                obj1.setData(Uri.parse("https://www.amazon.com"));
                startActivity(obj1);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3,s4;
                s1=et1.getText().toString();
                s2=et2.getText().toString();
                s3=s1+" "+s2;
                s4=etphonenumber.getText().toString();
                Intent obj= new Intent(MainActivity.this,Showpage.class);
                obj.putExtra("Key",s3);
                obj.putExtra("Ph",s4);//if u carry any value one to other page use this method
                startActivity(obj);
               // Toast.makeText(MainActivity.this, "Name is "  +s3, Toast.LENGTH_SHORT).show();

            }
        });

    }
}