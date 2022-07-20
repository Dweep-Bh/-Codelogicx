package com.example.recyclerview_demo_json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private ArrayList<SetGet> alist;
    private RecyclerView.Adapter adapter;
   // ArrayList<SetGet> alist= new ArrayList<SetGet>();
    String url="http://wptrafficanalyzer.in/p/demo1/first.php/countries/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = findViewById(R.id.main_list);
        alist=new ArrayList<>();
        adapter=new DweepAdapter(getApplicationContext(),alist);
        linearLayoutManager=new LinearLayoutManager(this);

        getData();

    }
    private void getData()
    {
       JsonObjectRequest jobreq=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               try {
                   JSONArray jr = response.getJSONArray("countries");
                   for(int i=0; i<jr.length(); i++)
                   {
                       JSONObject job=jr.getJSONObject(i);
                       String cname= job.getString("countryname");
                       String cflag= job.getString("flag");
                       String clang= job.getString("language");
                       String ccapital= job.getString("capital");


                       JSONObject innerobj= job.getJSONObject("currency");
                       String code= innerobj.getString("code");
                       String currencyname = innerobj.getString("currencyname");

                       SetGet st= new SetGet();

                       st.setCountryname(cname);
                       st.setFlag(cflag);
                       st.setLanguage(clang);
                       st.setCapital(ccapital);
                       st.setCode(code);
                       st.setCurrencyname(currencyname);
                       alist.add(st);
                   }
                   mList.setAdapter(adapter);
                   adapter.notifyDataSetChanged();
                   Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                   RecyclerView.LayoutManager lm=new GridLayoutManager(MainActivity.this,3);//this is for grid
                   mList.setLayoutManager(lm);

               } catch (JSONException e) {
                   e.printStackTrace();
               }

           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       });

    }


}

