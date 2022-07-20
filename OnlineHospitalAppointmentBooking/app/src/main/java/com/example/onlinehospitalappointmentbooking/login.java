package com.example.onlinehospitalappointmentbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

public class login extends AppCompatActivity {
    EditText username,password;
    Button login;
    DatabaseReference dr;
    FirebaseDatabase fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        fdb=FirebaseDatabase.getInstance();
        dr=fdb.getReference("Online hospital appointment");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1,s2;
                s1=username.getText().toString();
                s2=password.getText().toString();

                Intent obj=new Intent(login.this,Dashboard.class);
                startActivity(obj);

                userlogin(s1,s2);


            }

        });

    }
    private void userlogin (String username,String password)
    {
        AlertDialog.Builder obj1 = new AlertDialog.Builder(login.this);
        obj1.setTitle("Loggin In");
        obj1.setIcon(R.drawable.ic_launcher_background);
        obj1.setMessage("Please wait! While your Account is Logging In");
        obj1.setCancelable(false);
        obj1.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                obj1.setCancelable(true);
                Toast.makeText(login.this, "Successfully login", Toast.LENGTH_SHORT).show();
            }
        });

        obj1.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                obj1.setCancelable(true);
                Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
            }
        });
        obj1.show();
    }
}