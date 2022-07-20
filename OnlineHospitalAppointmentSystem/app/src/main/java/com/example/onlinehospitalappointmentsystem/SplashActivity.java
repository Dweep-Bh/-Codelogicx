package com.example.onlinehospitalappointmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView splash_logo,splash_logo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash_logo=findViewById(R.id.splash_logo);
        splash_logo1=findViewById(R.id.splash_logo1);

        new CountDownTimer(3000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent i= new Intent(SplashActivity.this,RegisterPatient.class);
                startActivity(i);
            }
        }.start();

    }
}