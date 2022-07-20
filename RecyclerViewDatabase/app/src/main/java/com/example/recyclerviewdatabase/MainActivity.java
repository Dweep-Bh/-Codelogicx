package com.example.recyclerviewdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button btnsave, btnshow;

    DatabaseReference dr;
    FirebaseDatabase fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        btnsave=findViewById(R.id.btnsave);
        btnshow=findViewById(R.id.btnshow);

        fdb=FirebaseDatabase.getInstance();
        dr=fdb.getReference("EJOB INDIA");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3,s4, s5;

                s1=et1.getText().toString();
                s2=et2.getText().toString();
                s3=et3.getText().toString();
                s4=et4.getText().toString();
                s5= s1+""+s2;

                createemployee(s1,s2,s3,s4);

            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(MainActivity.this,Showpage.class);
                startActivity(obj);


            }
        });

    }

    private void createemployee (String et1,String et2, String et3, String et4)
    {
        dr.child(et1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try
                {
                    if(snapshot.getValue()!=null)
                    {
                        Toast.makeText(MainActivity.this, "Already exist", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {

                        dr.child(et1).setValue(new User(et1,et2,et3,et4));
                        Toast.makeText(MainActivity.this, "Insert successfull", Toast.LENGTH_SHORT).show();

                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MainActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}