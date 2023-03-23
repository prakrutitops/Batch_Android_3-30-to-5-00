package com.example.tablayoutproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayoutproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
   /* lateinit var  toolbar:Toolbar
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout*/

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        setSupportActionBar(binding.toolbar)
        setupviewpager()
        binding.tab.setupWithViewPager(binding.Viewpager)

       /* toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.Viewpager)
        setupviewpager()


        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)
*/


    }

    private fun setupviewpager()
    {
            var adapter = MyAdapter(supportFragmentManager)
            adapter.mydata("CHAT",ChatFragment())
            adapter.mydata("STATUS",StatusFragment())
            adapter.mydata("CALL",CallFragment())
            binding.Viewpager.adapter= adapter

            /*var name="Xyz"
            var b = Bundle()
            b.putString("Tops",name)*/


     /*   val bundle = Bundle()
        bundle.putString("message", "From Activity")

// Set Fragmentclass Arguments

// Set Fragmentclass Arguments
        val fragobj = CallFragment()
        fragobj.setArguments(bundle)*/



       /*

        A to A - Intent
        A to F - Manager,Tran
        F to A
        F to F

        */


    }
}