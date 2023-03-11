package com.example.callsms


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RadioButtonEx : AppCompatActivity() {

    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton
    lateinit var rg:RadioGroup
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button_ex)

        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rg = findViewById(R.id.rg)

        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb1 ->
                    Toast.makeText(this, "male", Toast.LENGTH_SHORT).show()


                R.id.rb2 -> Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show()

            }
        })




    }


}