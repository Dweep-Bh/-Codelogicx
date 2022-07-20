package com.example.recyclerview_demo_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DweepAdapter extends RecyclerView.Adapter<DweepAdapter.Myholder> {
    private Context context;
    private ArrayList<SetGet> arrayList;

    public DweepAdapter(Context context, ArrayList<SetGet> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }





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

        SetGet st=arrayList.get(position);
//        holder.textTitle.setText(movie.getTitle());
//        holder.textRating.setText(String.valueOf(movie.getRating()));
//        holder.textYear.setText(String.valueOf(movie.getYear()));

        holder.textView.setText(arrayList.get(position).getCountryname());
        holder.textView.setText(arrayList.get(position).getLanguage());
        holder.textView.setText(arrayList.get(position).getCapital());
        holder.textView.setText(arrayList.get(position).getCode());
        holder.textView.setText(arrayList.get(position).getCurrencyname());


        // holder.imageView.setImageBitmap(alist.get(position).getFlag());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Myholder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.countryname);
            textView=itemView.findViewById(R.id.language);
            textView=itemView.findViewById(R.id.capital);
            textView=itemView.findViewById(R.id.code);
            textView=itemView.findViewById(R.id.currency);
            imageView=itemView.findViewById(R.id.flag);
        }
    }
}
