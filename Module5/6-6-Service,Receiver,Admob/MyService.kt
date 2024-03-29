package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service()
{

    override fun onBind(intent: Intent): IBinder
    {
        TODO("Return the communication channel to the service.")
    }

    override fun onStart(intent: Intent?, startId: Int)
    {
      Toast.makeText(applicationContext,"Start",Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        Toast.makeText(applicationContext,"Start Command",Toast.LENGTH_LONG).show()
        for(i in 1..10)
        {
            Thread.sleep(1000)
            Log.d("Ans",i.toString())
        }
        return START_STICKY
    }

    override fun onCreate()
    {
        Toast.makeText(applicationContext,"Created",Toast.LENGTH_LONG).show()

    }
    override fun onDestroy()
    {
        Toast.makeText(applicationContext,"Destroy",Toast.LENGTH_LONG).show()
    }
}