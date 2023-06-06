package com.example.myapplication

import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var mediaPlayer: MediaPlayer
    var url="https://vyasprakruti.000webhostapp.com/demo/iphone_13_original.mp3"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        //mediaPlayer = MediaPlayer.create(applicationContext,R.raw.iphone)

        //online


        var receiver = MyReceiver()
        var filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver,filter)



        btn1.setOnClickListener {

           /* var i = Intent(applicationContext,MyService::class.java)
            startService(i)*/
            mediaPlayer.start()

            if(mediaPlayer==null)
            {
                mediaPlayer = MediaPlayer()
                mediaPlayer.setDataSource(url)
                mediaPlayer.start()
            }
        }
        btn2.setOnClickListener {
          /*  var i = Intent(applicationContext,MyService::class.java)
            stopService(i)*/

            mediaPlayer.stop()
        }

    }
}