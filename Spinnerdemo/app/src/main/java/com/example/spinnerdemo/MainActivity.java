package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1;

    String [] state= {"Select the State ","West bengal","Tripura","up" ,"odisha", "kerala","Mp", "Goa","sikkim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1=findViewById(R.id.spinner1);

        // create a array adapter

        ArrayAdapter<String> obj= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,state);

        spinner1.setAdapter(obj);

        // Item selection from drop down
        
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = state[position];

                Toast.makeText(MainActivity.this, "State is" +item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}