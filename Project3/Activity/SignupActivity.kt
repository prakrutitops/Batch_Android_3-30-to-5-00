package com.example.project123.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.example.project123.Client.ApiClient
import com.example.project123.Interface.Apiinterface
import com.example.project123.R
import com.example.project123.databinding.ActivityLoginBinding
import com.example.project123.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivitySignupBinding
    lateinit var apiinterface: Apiinterface
    var gender=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textViewloginlink.setOnClickListener {

            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }

        binding.rbMale.setOnCheckedChangeListener(this)
        binding.rbFemale.setOnCheckedChangeListener(this)

        binding.btnsignup.setOnClickListener {

            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var email = binding.edtEmail.text.toString()
            var phone = binding.edtPhone.text.toString()
            var pass = binding.edtPassword.text.toString()

            apiinterface = ApiClient.getretofit()!!.create(Apiinterface::class.java)

            var call: Call<Void> =  apiinterface.registerdata(fname,lname,gender,email,phone,pass)
            call.enqueue(object :Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext,"Signup Successful",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,LoginActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }
            })


        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean)
    {
        if(binding.rbMale.isChecked)
        {
            gender ="Male"
        }
        else if(binding.rbFemale.isChecked)
        {
            gender ="Female"
        }
    }
}