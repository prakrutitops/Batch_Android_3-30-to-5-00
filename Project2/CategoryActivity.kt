package com.example.project123.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project123.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        var i = intent
        Toast.makeText(applicationContext,""+i.getIntExtra("position",111),Toast.LENGTH_LONG).show()
    }
}