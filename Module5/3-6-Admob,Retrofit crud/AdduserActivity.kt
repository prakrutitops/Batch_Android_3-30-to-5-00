package com.example.retrofitcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitcrud.databinding.ActivityAdduserBinding
import com.example.retrofitcrud.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdduserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        binding.btninsert.setOnClickListener {

            var pname = binding.edt1.text.toString()
            var pprice = binding.edt2.text.toString()

           var callback:Call<Void> = apiinterface.insertdata(pname,pprice)
            callback.enqueue(object :Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                   Toast.makeText(applicationContext,"Data Inserted",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }
            })


        }


    }
}