package com.example.json_post;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText etuname,etpassw;
    Button btn;
    ProgressBar pb;
    String url="http://14.99.214.220/onlineshoppingapp/show.asmx/LogIn";
   // HashMap<Integer,String> hm=new HashMap<Integer,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etuname=findViewById(R.id.etuname);
        etpassw=findViewById(R.id.etpassw);
        pb=findViewById(R.id.pb);
        btn=findViewById(R.id.btn);

//        hm.put(10,"Mango");
//        hm.put(11,"Orange");
//        hm.put(12,"Graphs");
//        hm.put(13,"Apple");
//        hm.put(14,"PineApple");
//        String s3=hm.get(14);
//
//        Toast.makeText(MainActivity.this, "Last fruit name is"+s3, Toast.LENGTH_SHORT).show();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2;
                s1=etuname.getText().toString();
                s2=etpassw.getText().toString();

                if(s1.length()==0 && (s2.length()==0))
                {
                    Toast.makeText(MainActivity.this, "please enter valid  email and password", Toast.LENGTH_SHORT).show();
                }
                else {


                    if (s1.length() > 0) {

                        if (s2.length() > 0) {
                            if(Util.isConnected(MainActivity.this))
                            {
                                pb.setVisibility(View.VISIBLE);
                                postToServer(url, s1, s2);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this, "No internet available", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "please enter a valid password ", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "please enter valid username", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }
    private void postToServer(String url,String uname,String passw)
    {
        StringRequest sreq=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pb.setVisibility(View.GONE);
                try {
                    JSONObject rootobj = new JSONObject(response);
                    JSONArray jr= rootobj.getJSONArray("User_Reg");
                    String suc= rootobj.getString("success");

                    if(suc.equalsIgnoreCase("1"))
                    {
                        JSONObject job=jr.getJSONObject(0);
                        String reg= job.getString("Reg_Id");
                        String email= job.getString("Email");
                        String pwd= job.getString("Pwd");
                        String name= job.getString("Name");
                        String phno = job.getString("Phoneno");
                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(MainActivity.this,Dashboard.class);
                        startActivity(intent);
                        //now go to dashboard page

                    }

                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pb.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map=new HashMap<String,String>();
                map.put("EmailId",uname);
                map.put("Pwd",passw);
                return map;
            }
        };
        Volley.newRequestQueue(MainActivity.this).add(sreq);
    }
}