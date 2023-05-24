package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.Activity.AdduserActivity
import com.example.myapplication.Adapter.MyAdapter
import com.example.myapplication.Database.MyDb
import com.example.myapplication.Entity.User
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<User>
    var db: MyDb? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext,
            MyDb::class.java, "myDatabase").allowMainThreadQueries().build()
        list = ArrayList()
        var l1: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=l1
        list = db!!.daoClass().getUsers()

        var adapter = MyAdapter(applicationContext,list)
        binding.recycler.adapter=adapter


        binding.f1.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))
        }
    }
}