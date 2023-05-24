package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.myapplication.Database.MyDb
import com.example.myapplication.Entity.User
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAdduserBinding
import com.example.myapplication.databinding.ActivityMainBinding

class AdduserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding
    var db: MyDb? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext,
            MyDb::class.java, "myDatabase").allowMainThreadQueries().build()

        binding.btninsert.setOnClickListener {

            var name = binding.edtname.text.toString()
            var pass = binding.edtpass.text.toString()

            var m = User()
            m.name=name
            m.pass=pass

            db!!.daoClass().insertdata(m)
            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

        }

        binding.btnview.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity::class.java))

        }
    }
}