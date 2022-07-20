package com.example.recyclerviewdatabase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DweepAdapter extends RecyclerView.Adapter<DweepAdapter.Myholder> {

    public DweepAdapter(ArrayList<User> alist, Context c) {
        this.alist = alist;
        this.c = c;
    }

    ArrayList<User> alist;
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
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {

        holder.tv1.setText(alist.get(position).getPhonenumber());
        holder.tv2.setText(alist.get(position).getEmployeename());
        holder.tv3.setText(alist.get(position).getEmployeeaddress());
        holder.tv4.setText(alist.get(position).getDesignation());
        holder.llchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(c,Editpage.class);
                intent.putExtra("Ph",alist.get(position).getPhonenumber());
                intent.putExtra("Name",alist.get(position).getEmployeename());
                intent.putExtra("Address",alist.get(position).getEmployeeaddress());
                intent.putExtra("Designation",alist.get(position).getDesignation());



                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alist.size();
    }

    class Myholder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        LinearLayout llchild;


        public Myholder(@NonNull View itemView) {
            super(itemView);

            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);
            tv4=itemView.findViewById(R.id.tv4);
            llchild=itemView.findViewById(R.id.llchild);
        }
    }
}
