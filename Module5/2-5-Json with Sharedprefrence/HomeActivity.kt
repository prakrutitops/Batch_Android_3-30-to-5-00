package com.example.signuplogin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.signuplogin.databinding.ActivityHomeBinding
import com.example.signuplogin.databinding.ActivityMain2Binding
import com.example.signuplogin.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)

        Toast.makeText(applicationContext,"Welcome: "+sharedPreferences.getString("PHONE",""),Toast.LENGTH_LONG).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext,MainActivity2::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}