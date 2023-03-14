package com.example.customlistex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter
    }

}