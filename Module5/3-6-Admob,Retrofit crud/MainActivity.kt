package com.example.retrofitcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcrud.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding
    lateinit var apiinterface: Apiinterface
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        var layoutmanager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layoutmanager



        var call: Call<List<Model>> = apiinterface.viewdata()

        call.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {

                list = response.body() as MutableList<Model>

                var myadapter = MyAdapter(applicationContext,list)
                binding.recycler.adapter=myadapter

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {

                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }
        })

        binding.f1.setOnClickListener {

                startActivity(Intent(applicationContext,AdduserActivity::class.java))

        }
    }

}