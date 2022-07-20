package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
 GridView Grid1;
 // how to insert image in array (int type)
 int arr [] = {R.drawable.img_01,R.drawable.img_02,R.drawable.img_03,R.drawable.img_04,R.drawable.img_05,R.drawable.img_06,R.drawable.img_07,R.drawable.img_08,R.drawable.img_09,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Grid1 = findViewById(R.id.Grid1);
        Dweep obj = new Dweep();
        Grid1.setAdapter(obj);


    }

    class  Dweep extends BaseAdapter
    {

        @Override
        public int getCount() {
            return arr.length;
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
            LayoutInflater inf=getLayoutInflater();
            View row = inf.inflate(R.layout.child,null);
            ImageView iv = row.findViewById(R.id.iv);
            iv.setImageResource(arr [position]); // to set image use this method setImageResource
            return row;
        }
    }
}