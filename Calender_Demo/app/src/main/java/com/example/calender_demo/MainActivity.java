package com.example.calender_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button btnDate,btnTime;
    int dd,mm,yy;
    int hr,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDate=findViewById(R.id.btnDate);
        btnTime=findViewById(R.id.btnTime);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                dd=c.get(Calendar.DAY_OF_MONTH);
                mm=c.get(Calendar.MONTH);
                yy=c.get(Calendar.YEAR);
                DatePickerDialog dp= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String mydate=dayOfMonth + "/" + (month+1) + "/" + year;
                        et1.setText(mydate);

                        Toast.makeText(MainActivity.this, "Date is"+ mydate, Toast.LENGTH_SHORT).show();

                    }

                },yy,mm,dd);
                 dp.show();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c= Calendar.getInstance();
                hr=c.get(Calendar.HOUR_OF_DAY);
                min=c.get(Calendar.MINUTE);
                TimePickerDialog tp=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String mytime=hourOfDay + ":" + minute;
                        et2.setText(mytime);

                    }
                },
                hr,min ,true);
                tp.show();
            }
        });
    }

}