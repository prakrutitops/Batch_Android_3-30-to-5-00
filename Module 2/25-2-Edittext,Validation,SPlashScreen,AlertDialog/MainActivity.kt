package com.example.myapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)


        //validation
        btn1.setOnClickListener {

            var n = edt1.text.toString()
            var p = edt2.text.toString()

            if(n.length==0 && p.length==0)
            {
                edt1.setError("Please Enter Name")
                edt2.setError("Please Enter Password")
            }
            else if(n.length==0)
            {
                edt1.setError("Please Enter Name")
            }
            else if(p.length==0)
            {
                edt2.setError("Please Enter Password")
            }
            else
            {
                if (n.equals("tops") && p.equals("1234"))
                {
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }

                else
                {
                    Toast.makeText(applicationContext,"Your Credentials are Wrong",Toast.LENGTH_LONG).show()
                }

            }
        }

    }
    override fun onBackPressed() {
        finishAffinity()
    }
}