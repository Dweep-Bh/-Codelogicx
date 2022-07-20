package com.example.json_demo;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class Util {
    static NetworkInfo wifidata,Mobiledata;

    public static boolean isConnected (Context c)

    {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);

        try {

            wifidata= cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            Mobiledata=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(wifidata!=null && wifidata.isAvailable() && wifidata.isConnected())
        {
            Toast.makeText(c, "wifi data on", Toast.LENGTH_SHORT).show();
//           AlertDialog.Builder ab=new AlertDialog.Builder(c);
//           ab.setTitle("info");
//           ab.setMessage("Internet not availabe");
//           ab.setCancelable(false);
//           ab.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//               @Override
//               public void onClick(DialogInterface dialog, int which) {
//                   ab.setCancelable(true);
//               }
//           });
//           ab.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
//               @Override
//               public void onClick(DialogInterface dialog, int which) {
//
//               }
//           });
//           ab.show();

            return true;
        }
        else if (Mobiledata!=null && Mobiledata.isAvailable() && Mobiledata.isConnected())
        {
           Toast.makeText(c, "mobile data is on", Toast.LENGTH_SHORT).show();



            return true;
        }
        else
        {
           // Toast.makeText(c, "please check your internet connection", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ab=new AlertDialog.Builder(c);
            ab.setTitle("info");
            ab.setMessage("Please check your internet connection");
            ab.setCancelable(false);
            ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ab.setCancelable(true);
                }
            });
            ab.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ab.setCancelable(false);
                }
            });
            ab.show();

            return false;
        }

    }
}
