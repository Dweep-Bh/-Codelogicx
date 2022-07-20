package com.example.alertdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder obj = new AlertDialog.Builder(MainActivity.this);
                obj.setTitle("!Warning");
                obj.setIcon(R.drawable.ic_launcher_background);
                obj.setMessage("No internet available");
                obj.setCancelable(false);
                obj.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        obj.setCancelable(true);
                        Toast.makeText(MainActivity.this, "You Clicked Ok", Toast.LENGTH_SHORT).show();
                    }
                });

                obj.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        obj.setCancelable(true);
                        Toast.makeText(MainActivity.this, "You Click Cancle", Toast.LENGTH_SHORT).show();
                    }
                });
                obj.show();

            }
        });
    }
}