package com.example.recyclerview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DweepAdapter extends RecyclerView.Adapter<DweepAdapter.Myholder> {
     String myarr1 [];
     Context c;

    public DweepAdapter(String[] myarr1, Context c) {
        this.myarr1 = myarr1;
        this.c = c;
    }

    @NonNull// only xml calling
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf=LayoutInflater.from(parent.getContext());
        View row=lf.inflate(R.layout.childxml,null);
        Myholder mh=new Myholder(row);
        return mh;
    }

    @Override// only data set here
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
          holder.textView.setText(myarr1[position]);
    }

    @Override
    public int getItemCount() {
        return myarr1.length;
    }

    class Myholder extends RecyclerView.ViewHolder{
       TextView textView;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textview);
        }
    }

}
