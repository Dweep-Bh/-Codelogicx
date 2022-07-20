package com.example.dynamicfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFragment extends Fragment {
    EditText et1,et2;
    Button btnSubmit;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        et1=getActivity().findViewById(R.id.et1);
        et2=getActivity().findViewById(R.id.et2);
        btnSubmit=getActivity().findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3;
                s1=et1.getText().toString();
                s2=et2.getText().toString();
                s3= s1 +" "+s2;

                Toast.makeText(getActivity(), "Your Name is"+ s3, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),Show.class);
                intent.putExtra("key",s3);
                startActivity(intent);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }
}