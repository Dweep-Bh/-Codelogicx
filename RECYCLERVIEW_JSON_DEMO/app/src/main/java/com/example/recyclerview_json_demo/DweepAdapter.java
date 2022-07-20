package com.example.recyclerview_json_demo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DweepAdapter extends RecyclerView.Adapter<DweepAdapter.Myholder> {


    public DweepAdapter(ArrayList<SetGet> alist1, Context c) {
        this.alist1 = alist1;
        this.c = c;
    }

    ArrayList<SetGet> alist1;
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

        holder.textView1.setText(alist1.get(position).getCountryname());
        holder.textView2.setText(alist1.get(position).getLanguage());
        holder.textView3.setText(alist1.get(position).getCapital());
        holder.textView4.setText(alist1.get(position).getCode());
        holder.textView5.setText(alist1.get(position).getCurrencyname());

        Picasso.with(c).load(alist1.get(position).getFlag()).into(holder.imgView);
        Log.i("img",c+"/"+alist1.get(position).getFlag());//for testing purpose



    }

    @Override
    public int getItemCount() {
        return alist1.size();
    }

    class Myholder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3,textView4,textView5;
        ImageView imgView;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            textView1=itemView.findViewById(R.id.countryname);
            textView2=itemView.findViewById(R.id.language);
            textView3=itemView.findViewById(R.id.capital);
            textView4=itemView.findViewById(R.id.code);
            textView5=itemView.findViewById(R.id.currency);
            imgView=itemView.findViewById(R.id.flag);

        }
    }

}
