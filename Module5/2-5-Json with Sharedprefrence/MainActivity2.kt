package com.example.signuplogin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.signuplogin.databinding.ActivityMain2Binding
import com.example.signuplogin.databinding.ActivityMainBinding
import org.json.JSONException

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    var gender=""
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("SESSION",false) && !sharedPreferences.getString("PHONE","")!!.isEmpty())
        {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }

        binding.btnLogIn.setOnClickListener {


            var phone = binding.edtmob.text.toString()
            var pass = binding.edtPassword.text.toString()

            var stringrequest:StringRequest= object : StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/API/login2.php",{response->
                try
                {
                        if(response.trim().equals("0"))
                        {
                            Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                        }
                        else
                        {
                            //Toast.makeText(applicationContext,"Login done",Toast.LENGTH_LONG).show()
                            var i = Intent(applicationContext,HomeActivity::class.java)
                            var editor :SharedPreferences.Editor = sharedPreferences.edit()
                            editor.putBoolean("SESSION",true)
                            editor.putString("PHONE",phone)
                            editor.putString("PASS",pass)
                            editor.commit()
                            startActivity(i)
                        }
                }
                catch (e:JSONException)
                {
                    e.printStackTrace()
                }
            },
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                }
            )






            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()


                    map["mob"]= phone
                    map["pass"]=pass

                    return map
                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)
        }
        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity::class.java))

        }


    }

    override fun onBackPressed() {
        finishAffinity()
    }


}