package com.example.toggle_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
 ToggleButton tb;
 LinearLayout line1;
 Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.tb);
        line1=findViewById(R.id.line1);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appdata.name="Dweep";
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String val=Appdata.name;
                Toast.makeText(MainActivity.this, "name  is  " + val, Toast.LENGTH_SHORT).show();
            }
        });
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true)
                {
                    Toast.makeText(MainActivity.this, "switch is on", Toast.LENGTH_SHORT).show();
                    line1.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "switch is off", Toast.LENGTH_SHORT).show();
                    line1.setBackgroundColor(Color.RED);
                }
            }
        });



    }
}