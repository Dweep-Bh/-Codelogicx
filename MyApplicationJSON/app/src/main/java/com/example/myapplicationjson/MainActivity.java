package com.example.myapplicationjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   // ListView list;
    RecyclerView recycleview;
    ProgressBar progress;
    String url="https://jsonplaceholder.typicode.com/users";
    ArrayList<SetGet> arrlist= new ArrayList<SetGet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   list=findViewById(R.id.list);
        recycleview=findViewById(R.id.recycleview);
        progress=findViewById(R.id.progress);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(MainActivity.this);
        recycleview.setLayoutManager(lm);
        getTheDataFromServer(url);
    }
    private void getTheDataFromServer(String url)
    {
        JsonArrayRequest jar=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    for (int j=0;j<response.length();j++)
                    {
                        JSONObject job = response.getJSONObject(j);
                        int id=job.optInt("id");
                        String name= job.getString("name");
                        String username=job.getString("username");
                        String emailid= job.getString("email");

                        JSONObject joj=job.getJSONObject("address");
                        String street= joj.getString("street");
                        String suite= joj.getString("suite");
                        String city= joj.getString("city");
                        String zipcode= joj.getString("zipcode");

                        JSONObject jso=joj.getJSONObject("geo");
                        String lat= jso.getString("lat");
                        String lng= jso.getString("lng");
                        String phno= job.getString("phone");
                        String website= job.getString("website");

                        JSONObject objj=job.getJSONObject("company");
                        String cname=objj.getString("name");
                        String catchphrase= objj.getString("catchPhrase");
                        String bs= objj.getString("bs");

                        SetGet sg=new SetGet();
                        sg.setId(id);
                        sg.setName(name);
                        sg.setUsername(username);
                        sg.setEmailId(emailid);
                        sg.setStreet(street);
                        sg.setSuite(suite);
                        sg.setCity(city);
                        sg.setZipcode(zipcode);
                        sg.setLat(lat);
                        sg.setLng(lng);
                        sg.setPhone(phno);
                        sg.setWebsite(website);
                        sg.setCname(cname);
                        sg.setCatchPhrase(catchphrase);
                        sg.setBs(bs);
                        arrlist.add(sg);
                    }
                 //   list.setAdapter(new Dweep());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                DweepAdapter adapter=new DweepAdapter(arrlist,MainActivity.this);
                recycleview.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Server error", Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(MainActivity.this).add(jar);
    }
   /* class Dweep extends BaseAdapter
    {

        @Override
        public int getCount() {
            return arrlist.size();
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
            LayoutInflater inf=getLayoutInflater();
            View row=inf.inflate(R.layout.child,null);
            TextView tv=row.findViewById(R.id.id1);

            String val= String.valueOf(arrlist.get(position).getId());
            tv.setText(val);     // for int value passing

            TextView tv1=row.findViewById(R.id.username);
            TextView tv2=row.findViewById(R.id.email);
            TextView tv3=row.findViewById(R.id.city);
            TextView tv4=row.findViewById(R.id.lat);
            TextView tv5=row.findViewById(R.id.lang);

            tv1.setText(arrlist.get(position).getUsername());
            tv2.setText(arrlist.get(position).getEmailId());
            tv3.setText(arrlist.get(position).getCity());
            tv4.setText(arrlist.get(position).getLat());
            tv5.setText(arrlist.get(position).getLng());
            return row;
        }*/
    }
