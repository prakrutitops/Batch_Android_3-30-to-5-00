package com.example.recyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        //LayoutManager

        var manager:RecyclerView.LayoutManager =LinearLayoutManager(this)
        binding.recycler.layoutManager = manager


        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))
        list.add(Model(R.mipmap.ic_launcher,"NOKIA","20000"))

        var adapter = MyAdapter(applicationContext,list)
        binding.recycler.adapter = adapter


    }
}