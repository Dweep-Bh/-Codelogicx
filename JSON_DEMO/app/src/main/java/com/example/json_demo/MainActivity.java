package com.example.json_demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.BackgroundServiceStartNotAllowedException;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
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
    ListView List_view;
    ProgressBar pb;

    String url="http://wptrafficanalyzer.in/p/demo1/first.php/countries/";
    ArrayList<SetGet> alist= new ArrayList<SetGet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List_view=findViewById(R.id.List_view);
        pb=findViewById(R.id.pb);
        if(Util.isConnected(MainActivity.this) ) {
            pb.setVisibility(View.VISIBLE);

            getDataFromServer(url);

        }

       else
        {
           // Toast.makeText(MainActivity.this, "No internet available", Toast.LENGTH_SHORT).show();



        }

    }

    private void getDataFromServer(String url)//Connect to server
    {
        JsonObjectRequest jobreq=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                pb.setVisibility(View.GONE);

                try {
                    JSONArray jr = response.getJSONArray("countries");
                    // JSONObject job=jr.getJSONObject(0);
                    for(int i=0; i<jr.length(); i++)
                    {
                        JSONObject job=jr.getJSONObject(i);
                        String cname= job.getString("countryname");
                        String cflag= job.getString("flag");
                        String clang= job.getString("language");
                        String ccapital= job.getString("capital");

                        JSONObject innerobj= job.getJSONObject("doctorde");
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

                    List_view.setAdapter(new Dweep());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pb.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(MainActivity.this).add(jobreq);
    }

      class Dweep extends BaseAdapter
    {

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
            LayoutInflater lf= getLayoutInflater();// for xml calling
            View row=lf.inflate(R.layout.child,parent,false);
            TextView tv = row.findViewById(R.id.countryname);
            TextView tv1 = row.findViewById(R.id.language);
            TextView tv2 = row.findViewById(R.id.capital);
            TextView tv3 = row.findViewById(R.id.code);
            TextView tv4 = row.findViewById(R.id.currency);
           // TextView tv5=row.findViewById(R.id.flag);

            tv.setText(alist.get(position).getCountryname());
            tv1.setText(alist.get(position).getLanguage());
            tv2.setText(alist.get(position).getCapital());
            tv3.setText(alist.get(position).getCode());
            tv4.setText(alist.get(position).getCurrencyname());

            ImageView iv1 = row.findViewById(R.id.flag);
            Picasso.with(MainActivity.this).load(alist.get(position).getFlag()).into(iv1);//for image pursing picasso is class, then pass context.

            return row;

        }
    }

}
