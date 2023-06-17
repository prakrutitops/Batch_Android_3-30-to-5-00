package com.example.project123.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project123.Client.ApiClient
import com.example.project123.Interface.Apiinterface
import com.example.project123.Model.HomeModel
import com.example.project123.R
import com.example.project123.databinding.ActivityHomeBinding
import com.example.project123.databinding.ActivityLoginBinding
import com.example.test.HomeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityHomeBinding
    lateinit var list:MutableList<HomeModel>
    lateinit var sharedPreferences: SharedPreferences
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("PHONE",""),Toast.LENGTH_LONG).show()

        list = ArrayList()
        binding.recycler.layoutManager = GridLayoutManager(this, 2)


        apiinterface = ApiClient.getretofit()!!.create(Apiinterface::class.java)

        var call: Call<List<HomeModel>> =  apiinterface.viewData()

        call.enqueue(object :Callback<List<HomeModel>>{
           override fun onResponse(call: Call<List<HomeModel>>, response: Response<List<HomeModel>>)
           {
                    list = response.body() as MutableList<HomeModel>

                    var adapter = HomeAdapter(applicationContext,list)
                    binding.recycler.adapter=adapter
           }

           override fun onFailure(call: Call<List<HomeModel>>, t: Throwable)
           {
              Toast.makeText(applicationContext,""+t.message,Toast.LENGTH_LONG).show()
           }
       })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {

        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}