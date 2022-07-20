package com.example.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
 Button btnsave,btnshow;
 EditText et1, et2;
 TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave=findViewById(R.id.btnsave);
        btnshow=findViewById(R.id.btnshow);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1, s2, s3;
                s1= et1.getText().toString();
                s2= et2.getText().toString();
                s3= s1+""+s2;
                SharedPreferences sf= getSharedPreferences("user",  MODE_PRIVATE);
                SharedPreferences.Editor editor= sf.edit();
                editor.putString("uname",s1);
                editor.putString("pwd",s2);
                editor.commit();
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf= getSharedPreferences("user",  MODE_PRIVATE);
                 String u,p;
                 u=sf.getString("uname","");
                 p=sf.getString("pwd","");
                 tv1.setText(u);
                 tv2.setText(p);


            }
        });
    }
}