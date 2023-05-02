package com.example.signuplogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.signuplogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding
    var gender=""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.rbMale.setOnCheckedChangeListener(this)
        binding.rbFemale.setOnCheckedChangeListener(this)


        binding.btnsignup.setOnClickListener {

            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var email = binding.edtEmail.text.toString()
            var phone = binding.edtPhone.text.toString()
            var pass = binding.edtPassword.text.toString()

            var stringrequest:StringRequest= object : StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/API/signup.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"Registration Done",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))

            },Response.ErrorListener {

                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })

            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()

                        map["firstname"]= fname
                        map["lastname"]=lname
                        map["gender"]=gender
                        map["email"]=email
                        map["phone"]= phone
                        map["password"]=pass

                    return map
                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)
        }
        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }


    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean)
    {
        if(binding.rbMale.isChecked)
        {
            gender="Male"
        }

        if(binding.rbFemale.isChecked)
        {
            gender="Female"
        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}