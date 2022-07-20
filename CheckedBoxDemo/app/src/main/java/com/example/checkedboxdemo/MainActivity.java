package com.example.checkedboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox CB1,CM1,CM2,CM3; // initialize variable
Button btnext2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CB1=findViewById(R.id.CB1); // declare the variable
        CM1=findViewById(R.id.CM1);
        CM2=findViewById(R.id.CM2);
        CM3=findViewById(R.id.CM3);
        btnext2=findViewById(R.id.btnext2);



        btnext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String Result = "selected Courses";

              if (CB1.isChecked()==true)
              {
                  Result += "\n B.Tech";

              }
                if (CM1.isChecked()==true)
                {
                    Result += "\n M.Tech";

                }

                if (CM2.isChecked()==true)
                {
                    Result += "\n MBA";

                }
                if (CM3.isChecked()==true)
                {
                    Result += "\n PHD";

                }

                Toast.makeText(MainActivity.this, Result, Toast.LENGTH_SHORT).show();




            }
        });

    }
}