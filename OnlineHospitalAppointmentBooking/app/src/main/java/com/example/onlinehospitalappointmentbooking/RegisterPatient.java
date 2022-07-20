package com.example.onlinehospitalappointmentbooking;

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

public class RegisterPatient extends AppCompatActivity {
    EditText firstname,lastname,username,password,address,phonenumber,emailid;
    Button registration;

    DatabaseReference dr;
    FirebaseDatabase fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        address=findViewById(R.id.address);
        phonenumber=findViewById(R.id.phonenumber);
        emailid=findViewById(R.id.emailid);
        registration=findViewById(R.id.registration);
        fdb=FirebaseDatabase.getInstance();
        dr=fdb.getReference("Online hospital appointment");

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1,s2,s3,s4,s5,s6,s7;

                s1=firstname.getText().toString();
                s2=lastname.getText().toString();
                s3=username.getText().toString();
                s4=password.getText().toString();
                s5=address.getText().toString();
                s6=phonenumber.getText().toString();
                s7=emailid.getText().toString();

                Intent obj=new Intent(RegisterPatient.this,login.class);
                startActivity(obj);

                allpatient(s1,s2,s3,s4,s5,s6,s7);



            }
        });
    }

    private void allpatient(String firstname,String lastname,String username, String password,String address,String phonenumber,String emailid)
    {
        dr.child(phonenumber).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try
                {
                    if(snapshot.getValue()!=null)
                    {
                        Toast.makeText(RegisterPatient.this, "Already exist", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {

                        dr.child(phonenumber).setValue(new User(firstname,lastname,username,password,address,phonenumber,emailid));
                        Toast.makeText(RegisterPatient.this, "Insert successfull", Toast.LENGTH_SHORT).show();

                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(RegisterPatient.this, "Server Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}