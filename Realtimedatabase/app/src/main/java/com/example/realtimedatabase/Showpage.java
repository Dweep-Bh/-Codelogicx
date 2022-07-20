package com.example.realtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Showpage extends AppCompatActivity {
     ArrayList<User> alist= new ArrayList<>();
     ListView List1;

    DatabaseReference dr;
    FirebaseDatabase fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpage);

        List1=findViewById(R.id.List1);
        fdb=FirebaseDatabase.getInstance();
        dr=fdb.getReference("Employee");
        showData();


    }

    class Dweep extends BaseAdapter {

        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inf= getLayoutInflater();
            View row = inf.inflate(R.layout.child,parent,false);

            TextView tv1 = row.findViewById(R.id.tv1);
            TextView tv2 = row.findViewById(R.id.tv2);
            TextView tv3 = row.findViewById(R.id.tv3);
            TextView tv4 = row.findViewById(R.id.tv4);

            tv1.setText(alist.get(position).getPhonenumber());
            tv2.setText(alist.get(position).getEmployeename());
            tv3.setText(alist.get(position).getEmployeeaddress());
            tv4.setText(alist.get(position).getDesignation());

            return row;
        }

    }

    private void showData ()
    {
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                alist.clear();

                for (DataSnapshot ds : snapshot.getChildren())
                {
                    User us=ds.getValue(User.class);
                    alist.add(us);
                }
                if(alist.size()>0)
                {
                    Dweep obj = new Dweep ();
                    List1.setAdapter(obj);
                    List1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent intent=new Intent(Showpage.this,EditPage.class);

                            intent.putExtra("Ph",alist.get(position).getPhonenumber());
                            intent.putExtra("Name",alist.get(position).getEmployeename());
                            intent.putExtra("Address",alist.get(position).getEmployeeaddress());
                            intent.putExtra("Designation",alist.get(position).getDesignation());


                            startActivity(intent);


                        }
                    });
                }

                else
                {
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