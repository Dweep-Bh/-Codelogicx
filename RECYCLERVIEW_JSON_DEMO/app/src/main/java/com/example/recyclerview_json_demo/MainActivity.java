package com.example.recyclerview_json_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleview;
    ArrayList<SetGet> alist = new ArrayList<SetGet>();
    String url = "http://wptrafficanalyzer.in/p/demo1/first.php/countries/";


    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleview = findViewById(R.id.recycleview);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
        recycleview.setLayoutManager(lm);

        getDataFromServer(url);

    }

    private void getDataFromServer(String url) {
        JsonObjectRequest jobreq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jr = response.getJSONArray("countries");
                    for (int i = 0; i < jr.length(); i++) {
                        JSONObject job = jr.getJSONObject(i);
                        String cname = job.getString("countryname");
                        String cflag = job.getString("flag");
                        String clang = job.getString("language");
                        String ccapital = job.getString("capital");

                        JSONObject innerobj = job.getJSONObject("currency");
                        String code = innerobj.getString("code");
                        String currencyname = innerobj.getString("currencyname");

                        SetGet st = new SetGet();

                        st.setCountryname(cname);
                        st.setFlag(cflag);
                        st.setLanguage(clang);
                        st.setCapital(ccapital);
                        st.setCode(code);
                        st.setCurrencyname(currencyname);
                        alist.add(st);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                DweepAdapter adapter=new DweepAdapter(alist,MainActivity.this);
                recycleview.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        Volley.newRequestQueue(MainActivity.this).add(jobreq);

    }




    }
