package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMain2Binding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Context

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    //lateinit var db: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        FirebaseApp.initializeApp(applicationContext)
        setContentView(view)
        //db= FirebaseDatabase.getInstance()
        binding.btninsert.setOnClickListener {

            var name1 = binding.edt1.text.toString()
            var email1 = binding.edt2.text.toString()
            var pass1 = binding.edt3.text.toString()

            var map = HashMap<String,String>()
            map["name"]=name1
            map["email"]=email1
            map["pass"]=pass1

            var db = FirebaseDatabase.getInstance().getReference()
                .child("info")
                .push()
                .setValue(map)
                .addOnSuccessListener()
                {
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                }
                .addOnFailureListener()
                {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
        }

    }
}