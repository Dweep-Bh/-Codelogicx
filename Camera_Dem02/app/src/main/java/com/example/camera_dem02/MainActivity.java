package com.example.camera_dem02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button BtnCamera;
    ImageView ImgCamera;
    private static final int Call_to_camera = 200;
    int req_code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnCamera = findViewById(R.id.BtnCamera);
        ImgCamera = findViewById(R.id.ImgCamera);
        BtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=23)
                {   // TAKING PERMISSION FROM MANIFEST AND PUT INTO INTEGER VARIABLE PERMISSION
                    int permission= ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CAMERA);
                    if(permission != PackageManager.PERMISSION_GRANTED)// Manager not get permission
                    {
                        ActivityCompat.requestPermissions(MainActivity.this,new String []{
                                Manifest.permission.CAMERA
                        },req_code);
                    }
                    else
                    {
                        opencamera();
                    }
                }
                else
                {
                    opencamera();
                }



            }
        });

    }
    private void opencamera()
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//to communicate with component
        startActivityForResult(intent,req_code);// To show the result on samePage
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Call_to_camera && resultCode == RESULT_OK) {
            Bitmap imagephoto = (Bitmap) data.getExtras().get("data");
            ImgCamera.setImageBitmap(imagephoto);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (req_code == requestCode) {
            if (grantResults[0] > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                  opencamera();
                } else {
                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}