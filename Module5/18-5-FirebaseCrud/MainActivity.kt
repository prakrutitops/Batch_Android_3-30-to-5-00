package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var myAdapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val rl: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = rl


        val options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("info"), Model::class.java)
            .build()

        myAdapter = MyAdapter(applicationContext,options)
        binding.recycler.adapter=myAdapter

        binding.f1.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }

    }

    override fun onStart() {
        super.onStart()
        myAdapter.startListening()
    }
    override fun onStop() {
        super.onStop()
        myAdapter.stopListening()
    }

    override fun onResume() {
        super.onResume()
        myAdapter.startListening()
    }

    override fun onRestart() {
        super.onRestart()
        myAdapter.startListening()
    }

    override fun onPause() {
        super.onPause()
        myAdapter.stopListening()
    }
}