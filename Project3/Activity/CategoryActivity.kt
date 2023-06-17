package com.example.project123.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project123.Client.ApiClient
import com.example.project123.Interface.Apiinterface
import com.example.project123.Model.ArtModel
import com.example.project123.Model.HomeModel
import com.example.project123.R
import com.example.project123.databinding.ActivityCategoryBinding
import com.example.project123.databinding.ActivityHomeBinding
import com.example.test.CategoryAdapter
import com.example.test.HomeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCategoryBinding
    lateinit var list:MutableList<ArtModel>
    lateinit var apiinterface: Apiinterface
    lateinit var call:Call<List<ArtModel>>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        Toast.makeText(applicationContext,""+i.getIntExtra("position",111),Toast.LENGTH_LONG).show()
        var pos = i.getIntExtra("position",111)

        list = ArrayList()
        binding.recycler.layoutManager = GridLayoutManager(this, 2)


        apiinterface = ApiClient.getretofit()!!.create(Apiinterface::class.java)

        if(pos==0)
        {
             call =  apiinterface.art1view()
        }
        if(pos==1)
        {
             call=  apiinterface.art2view()
        }
        if(pos==2)
        {
            //var call: Call<List<HomeModel>> =  apiinterface.viewData()
        }

        call.enqueue(object :Callback<List<ArtModel>>{
            override fun onResponse(call: Call<List<ArtModel>>, response: Response<List<ArtModel>>)
            {
                list = response.body() as MutableList<ArtModel>

                var adapter = CategoryAdapter(applicationContext,list)
                binding.recycler.adapter=adapter
            }

            override fun onFailure(call: Call<List<ArtModel>>, t: Throwable) {
                Toast.makeText(applicationContext,""+t.message,Toast.LENGTH_LONG).show()
            }

        })

    }
}