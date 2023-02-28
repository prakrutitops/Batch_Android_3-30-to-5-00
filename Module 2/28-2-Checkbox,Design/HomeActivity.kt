package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class HomeActivity : AppCompatActivity()
{
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

                var amount = 0
                var builder = StringBuilder("")
                builder.append("\n selected Items \n")


               if(chk1.isChecked)
               {
                   builder.append("\n Pizza @ Rs. 100 \n")
                   amount+=100
               }
                if(chk2.isChecked)
                {
                    builder.append("\n Burger @ Rs. 70 \n")
                    amount+=70
                }
                if(chk3.isChecked)
                {
                    builder.append("\n Coffee @ Rs. 120 \n")
                    amount+=120
                }
                builder.append("\n Total: "+amount)

                //Toast.makeText(applicationContext,""+builder.toString(),Toast.LENGTH_LONG).show()
                //Log.d("BILL",builder.toString())

                var i = Intent(applicationContext,BillActivity::class.java)
                i.putExtra("BILL",builder.toString())
                startActivity(i)


        }

    }
}