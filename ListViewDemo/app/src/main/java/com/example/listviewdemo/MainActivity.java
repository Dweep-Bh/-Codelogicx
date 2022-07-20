package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView List1;
    String [] myarr ={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec"};
    int [] arr ={R.drawable.img_01,R.drawable.img_02,R.drawable.img_03,R.drawable.img_04,R.drawable.img_05,R.drawable.img_06,R.drawable.img_07,R.drawable.img_08,R.drawable.img_09,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List1 = findViewById(R.id.List1);
        // calling your adapter class here
        Dweep obj = new Dweep();
        List1.setAdapter(obj); // pass data adapter to list due to bridge connection
    }
    class Dweep extends BaseAdapter // BaseAdapter is a super class
    {

        @Override
        public int getCount() { // how many row you want
            return myarr.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inf= getLayoutInflater();// create a LayoutInflater object for calling external any xml(Child)
            View row = inf.inflate(R.layout.child,parent,false);// to store the external xml creat a variable
            TextView tv = row.findViewById(R.id.tv1); // find textview using parent referrence
            tv.setText(myarr[position]);// set data in text view from array
            ImageView iv1 = row.findViewById(R.id.iv1);
            iv1.setImageResource(arr[position]);
            return row;


        }
    }
}