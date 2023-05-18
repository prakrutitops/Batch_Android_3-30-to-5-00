package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityUpdateBinding
import com.google.firebase.FirebaseApp

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var name = i.getStringExtra("n1")
        var email = i.getStringExtra("e1")
        var pass = i.getStringExtra("p1")

        binding.edt1.setText(name)
        binding.edt2.setText(email)
        binding.edt3.setText(pass)
        binding.btnupdate.setOnClickListener {




        }
    }
}