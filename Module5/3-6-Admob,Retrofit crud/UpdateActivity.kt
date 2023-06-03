package com.example.retrofitcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitcrud.databinding.ActivityAdduserBinding
import com.example.retrofitcrud.databinding.ActivityUpdateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("id",101)
        binding.edt1.setText(i.getStringExtra("name"))
        binding.edt2.setText(i.getStringExtra("price"))

        Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        binding.btnupdate.setOnClickListener {


            var name = binding.edt1.text.toString()
            var price = binding.edt2.text.toString()

            var call: Call<Void> = apiinterface.updatedata(id,name,price)
            call.enqueue(object :Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext,"Updated",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                }
            })


        }



    }
}