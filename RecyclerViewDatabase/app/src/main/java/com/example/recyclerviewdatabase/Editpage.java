package com.example.recyclerviewdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Editpage extends AppCompatActivity {
    EditText etp,ete,eta,etd;
    Button btnupdate,btndelete;

    DatabaseReference dr;
    FirebaseDatabase fdb;

    String eph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpage);
        etp=findViewById(R.id.etp);
        ete=findViewById(R.id.ete);
        eta=findViewById(R.id.eta);
        etd=findViewById(R.id.etd);

        btnupdate=findViewById(R.id.btnupdate);
        btndelete=findViewById(R.id.btndelete);

        fdb=FirebaseDatabase.getInstance();
        dr=fdb.getReference("EJOB INDIA");

        eph=getIntent().getExtras().getString("Ph");
        etp.setText(eph);

        String eph1=getIntent().getExtras().getString("Name");
        ete.setText(eph1);

        String eph2=getIntent().getExtras().getString("Address");
        eta.setText(eph2);

        String eph3=getIntent().getExtras().getString("Designation");
        etd.setText(eph3);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3,s4;

                // s1=etp.getText().toString();
                s2=ete.getText().toString();
                s3=eta.getText().toString();
                s4=etd.getText().toString();

                updateentity(eph,s2,s3,s4);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteentity (eph);
            }
        });
    }
    private  void updateentity(String etp,String ete, String eta, String etd)
    {
        dr.child(eph).setValue(new User(etp,ete,eta,etd));
        Toast.makeText(Editpage.this, "data update successfully", Toast.LENGTH_SHORT).show();
    }

    private void deleteentity (String eph)
    {

        dr.child(eph).removeValue();
        Toast.makeText(Editpage.this, "data delete successfully", Toast.LENGTH_SHORT).show();

    }
}