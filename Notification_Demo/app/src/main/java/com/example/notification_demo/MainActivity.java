package com.example.notification_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsend=findViewById(R.id.btnsend);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendmsg();
            }
        });
    }

    private void sendmsg()
    {

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_ONE_SHOT);//  create token
        String Channelid="Abc";
        Uri Sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);// sound purpose
        NotificationCompat.Builder obj= new NotificationCompat.Builder(MainActivity.this,Channelid);
        obj.setSmallIcon(R.mipmap.image_1);
        obj.setContentTitle("one new text in WhatsApp");
        obj.setContentText("New Notification");
        obj.setAutoCancel(true);
        obj.setSound(Sound);
        obj.setContentIntent(pi);
        NotificationManager nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int abc=NotificationManager.IMPORTANCE_HIGH;
        // Check version here
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel inchannel=new NotificationChannel(Channelid,"msg",abc);
            nm.createNotificationChannel(inchannel);
        }
        nm.notify(0,obj.build());

    }
}