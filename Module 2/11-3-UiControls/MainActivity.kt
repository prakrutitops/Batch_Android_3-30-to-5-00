package com.example.callsms

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.SEND_SMS
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //permission code
        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(this,arrayOf(CALL_PHONE),101)
        }

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED && checkSelfPermission(SEND_SMS)!=PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(this,arrayOf(SEND_SMS),101)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            //call
            R.id.i1->
            {
                var num ="999999999"
                var i = Intent(Intent.ACTION_CALL)
                i.setData(Uri.parse("tel:"+num))
                startActivity(i)
            }

            //sms
            R.id.i2->
            {
                var num="7226804490"
                var sm:SmsManager = SmsManager.getDefault()
                sm.sendTextMessage(num,null,"Hello From Tops",null,null)
                Toast.makeText(applicationContext,"Sms Sent",Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}