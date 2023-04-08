package com.example.sqliteex

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
    lateinit var btn2:Button
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        dbHelper = DbHelper(applicationContext)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()

            var m = Model()
            m.name=name
            m.num=num

            var id = dbHelper.savedata(m)
            Toast.makeText(applicationContext,"Record inserted "+id,Toast.LENGTH_LONG).show()

        }


    }
}