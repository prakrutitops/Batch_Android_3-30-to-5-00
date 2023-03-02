package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListDataActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)


        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add("123")
        list.add("456")
        list.add("123")
        list.add("123")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter =adapter

        registerForContextMenu(listView)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {

        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var acm :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        Toast.makeText(applicationContext,""+acm.position,Toast.LENGTH_LONG).show()

        return super.onContextItemSelected(item)
    }

}