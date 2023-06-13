package com.example.project123.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject_batch_1130.Model.RegisterModel
import com.example.project123.Client.ApiClient
import com.example.project123.Interface.Apiinterface
import com.example.project123.R
import com.example.project123.databinding.ActivityLoginBinding
import com.example.project123.databinding.ActivitySplashScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnLogIn.setOnClickListener {


            var phone = binding.edtphone.text.toString()
            var pass = binding.edtPassword.text.toString()

            apiinterface = ApiClient.getretofit()!!.create(Apiinterface::class.java)

            var call: Call<RegisterModel> =  apiinterface.logindata(phone,pass)
            call.enqueue(object :Callback<RegisterModel>{
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>
                ) {
                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()
                }
            })


        }

        binding.textViewregisterlink.setOnClickListener {

            startActivity(Intent(applicationContext,SignupActivity::class.java))
        }


    }
}