package com.example.callsms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerEx : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spin:Spinner
    var cityarray = arrayOf("Surat","Ahmedabad","Rajkot")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_ex)

        spin = findViewById(R.id.spin)

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,cityarray)
        spin.adapter=adapter

        spin.setOnItemSelectedListener(this)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(applicationContext,""+cityarray[position],Toast.LENGTH_LONG).show()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}