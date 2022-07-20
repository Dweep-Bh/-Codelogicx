package com.example.recyclerviewdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Showpage extends AppCompatActivity {
    ArrayList<User> alist = new ArrayList<>();
    RecyclerView recv;
    DatabaseReference dr;
    FirebaseDatabase fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpage);
        recv = findViewById(R.id.recv);
        fdb = FirebaseDatabase.getInstance();
        dr = fdb.getReference("EJOB INDIA");
        RecyclerView.LayoutManager lm = new LinearLayoutManager(Showpage.this);
        recv.setLayoutManager(lm);
        showData();


    }

    private void showData() {
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                alist.clear();

                for (DataSnapshot ds : snapshot.getChildren()) {
                    User us = ds.getValue(User.class);
                    alist.add(us);
                }
                if (alist.size() > 0) {
                    DweepAdapter adapter=new DweepAdapter(alist,Showpage.this);
                    recv.setAdapter(adapter);

                } else {
                    Toast.makeText(Showpage.this, "No data found", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Showpage.this, "Server Error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}