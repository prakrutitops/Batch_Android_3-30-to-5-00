package com.example.networkconnecton;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button=findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isConnected())
                {
                    Toast.makeText(MainActivity.this, "INTERNET CONNECTED", Toast.LENGTH_SHORT).show();
                }
                else 
                {
                    Toast.makeText(MainActivity.this, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isConnected()
    {
        boolean connected=false;
        try
        {
            ConnectivityManager cm= (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ninfo=cm.getActiveNetworkInfo();
            connected=ninfo !=null && ninfo.isAvailable() &&ninfo.isConnected();
            return connected;

        }
        catch (Exception e)
        {
            Log.e("connection exception",e.getMessage());
        }
        return connected;
    }
}
