package com.example.project123.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.project123.R
import com.example.project123.databinding.ActivityMainBinding
import com.example.project123.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Handler().postDelayed(Runnable {

                startActivity(Intent(applicationContext,LoginActivity::class.java))

        },3000)
    }
}