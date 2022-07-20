package com.example.myapplicationjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DweepAdapter extends RecyclerView.Adapter<DweepAdapter.Myholder> {


    public DweepAdapter(ArrayList<SetGet> arrayList, Context c) {
        this.arrayList = arrayList;
        this.c = c;
    }

    ArrayList<SetGet> arrayList;
    Context c;



    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf=LayoutInflater.from(parent.getContext());
        View row=lf.inflate(R.layout.child,null);
        Myholder mh=new Myholder(row);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        String val= String.valueOf(arrayList.get(position).getId());
        holder.tv.setText(val);


        holder.tv1.setText(arrayList.get(position).getUsername());
        holder.tv2.setText(arrayList.get(position).getEmailId());
        holder.tv3.setText(arrayList.get(position).getCity());
        holder.tv4.setText(arrayList.get(position).getLat());
        holder.tv5.setText(arrayList.get(position).getLng());
      //  String val= String.valueOf(arrayList.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Myholder extends RecyclerView.ViewHolder {
        TextView tv, tv1,tv2,tv3,tv4,tv5;


        public Myholder(@NonNull View itemView) {
            super(itemView);

            tv=itemView.findViewById(R.id.id1);
            tv1=itemView.findViewById(R.id.username);
            tv2=itemView.findViewById(R.id.email);
            tv3=itemView.findViewById(R.id.city);
            tv4=itemView.findViewById(R.id.lat);
            tv5=itemView.findViewById(R.id.lang);
        }
    }
}
