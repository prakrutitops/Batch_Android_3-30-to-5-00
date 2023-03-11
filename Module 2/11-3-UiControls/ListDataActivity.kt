package com.example.callsms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class ListDataActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var searchView: SearchView
    lateinit var list: MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)

        listView = findViewById(R.id.list)
        searchView = findViewById(R.id.search)
        list = ArrayList()

        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("Python")
        list.add("IOS")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter


        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               /* if(list.contains(query))
                {
                    adapter.filter.filter(query)
                }*/
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })


    }


}