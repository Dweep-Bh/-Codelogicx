package com.example.onlinehospitalappointmentbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Browser;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ListView List_view;
    ProgressBar pb;

    String url =" http://14.99.214.220/drbookingapp/bookingapp.asmx";
    ArrayList<SetGet> alist=new ArrayList<SetGet>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        List_view=findViewById(R.id.List_view);
        getDataFromServer(url);
    }

    private void getDataFromServer(String url)
    {
        JsonObjectRequest jobreq=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jr=response.getJSONArray("DepartmentDetails");
                    for (int i=0;i< jr.length();i++)
                    {
                        JSONObject job= jr.getJSONObject(i);
                        String gm=job.getString("generalmedicine");
                        String cd=job.getString("cardiologist");
                        String op=job.getString("orthopedic");
                        String gs=job.getString("gastroentrologist");
                        String ns=job.getString("neurologist");
                        String sk=job.getString("skin");

                        SetGet st= new SetGet();

                        st.setGeneralmedicine(gm);
                        st.setCardiologist(cd);
                        st.setOrthopedic(op);
                        st.setGastroentrologist(gs);
                        st.setNeurologist(ns);
                        st.setSkin(sk);
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
                Toast.makeText(Dashboard.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(Dashboard.this).add(jobreq);
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
            View row=lf.inflate(R.layout.dashboardchild,parent,false);
            TextView tv= row.findViewById(R.id.generalmedicine);
            TextView tv1= row.findViewById(R.id.cardiologist);
            TextView tv2= row.findViewById(R.id.orthopedic);
            TextView tv3= row.findViewById(R.id.gastroentrologist);
            TextView tv4= row.findViewById(R.id.neurologist);
            TextView tv5= row.findViewById(R.id.skin);
            tv.setText(alist.get(position).getGeneralmedicine());
            tv1.setText(alist.get(position).getCardiologist());
            tv2.setText(alist.get(position).getOrthopedic());
            tv3.setText(alist.get(position).getGastroentrologist());
            tv4.setText(alist.get(position).getNeurologist());
            tv5.setText(alist.get(position).getSkin());
            return row;
        }
    }
}