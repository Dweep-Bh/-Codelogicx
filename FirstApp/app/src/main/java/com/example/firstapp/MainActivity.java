package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7; // declare variable
    EditText et1,et2,et3,et4,et5,et6;
    Button bt1,bt2;
    RadioButton rb1,rb2;
    String Gender ="";

// this is main function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// here xml files are connected with java

        tv1=findViewById(R.id.tv1); // initializing our variable
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
        et6=findViewById(R.id.et6);

        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        
        // this button is used for click on Radiobutton
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)

            {
                if (isChecked==true)
                {
                    Gender ="Male";
                }

            }
        });
        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked==true)
                {
                    Gender = "Female";
                }

            }
        });


// this function is used to click

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v)
            {
                // for print any message
                String s1,s2,s3, s4,s5,s6;
               s1= et1.getText().toString();
               s2= et2.getText().toString();
               s3= s1+"  "+ s2;
               s4= et3.getText().toString();
               s5= et4.getText().toString();
               s6= et5.getText().toString();

                Toast.makeText(MainActivity.this,"Gender is - "+Gender,Toast.LENGTH_LONG).show();
                // Toast.makeText(MainActivity.this,"Gender is - "+s1+""+s2+""+s3+""+s4+""+s5+""+s6,Toast.LENGTH_LONG).show();
            }
        });





    }
}