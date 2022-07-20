package com.example.animation_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Button btnfadein,btnfadeout,btnrotate,btnblink;
    Animation fin,fout,rotate,blink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.tv1);
        btnfadein=findViewById(R.id.btnfadein);
        btnfadeout=findViewById(R.id.btnfadeout);
        btnrotate=findViewById(R.id.btnrotate);
        btnblink=findViewById(R.id.btnblink);
        fin= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadein);
        fout=AnimationUtils.loadAnimation(MainActivity.this,R.anim.fadeout);
        rotate=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
        blink=AnimationUtils.loadAnimation(MainActivity.this,R.anim.blink);

        btnfadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.startAnimation(fin);

            }
        });
        btnfadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.startAnimation(fout);
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.startAnimation(rotate);

            }
        });
        btnblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.startAnimation(blink);

            }
        });
    }
}