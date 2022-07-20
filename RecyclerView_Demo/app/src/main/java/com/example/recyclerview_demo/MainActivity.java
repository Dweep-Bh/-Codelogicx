package com.example.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleview;
    String myarr []={"Jan","Feb","Mar","April","May","Jun","July","Aug","Sept","Oct","Nov","Dec","Jan","Feb","Mar","April","May","Jun","July","Aug","Sept","Oct","Nov","Dec","Jan","Feb","Mar","April","May","Jun","July","Aug","Sept","Oct","Nov","Dec","Jan","Feb","Mar","April","May","Jun","July","Aug","Sept","Oct","Nov","Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleview=findViewById(R.id.recycleview);
        // view mode
//
//        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
//        recycleview.setLayoutManager(lm);// this is for list
        RecyclerView.LayoutManager lm=new GridLayoutManager(MainActivity.this,3);//this is for grid
        recycleview.setLayoutManager(lm);
        DweepAdapter obj=new DweepAdapter(myarr,MainActivity.this);
        recycleview.setAdapter(obj);


    }

}