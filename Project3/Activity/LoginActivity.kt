package com.example.project123.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("USER_SESSION",Context.MODE_PRIVATE)


        if (sharedPreferences.getBoolean("USER_SESSION", false) && sharedPreferences.getString("PHONE", "")!!
                .isNotEmpty())
        {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }


        binding.btnLogIn.setOnClickListener {


            var phone = binding.edtphone.text.toString()
            var pass = binding.edtPassword.text.toString()

            apiinterface = ApiClient.getretofit()!!.create(Apiinterface::class.java)

            var call: Call<RegisterModel> =  apiinterface.logindata(phone,pass)
            call.enqueue(object :Callback<RegisterModel>{
                override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>)
                {
                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                    var edit:SharedPreferences.Editor = sharedPreferences.edit()
                    edit.putString("PHONE",phone)
                    edit.putString("PASS",pass)
                    edit.putBoolean("USER_SESSION",true)
                    edit.commit()


                    startActivity(Intent(applicationContext,HomeActivity::class.java))

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