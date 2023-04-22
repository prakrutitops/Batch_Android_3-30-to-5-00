package com.example.insertdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.insertdata.databinding.ActivityAddUserBinding
import com.example.insertdata.databinding.ActivityMainBinding

class AddUserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAddUserBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.btn1.setOnClickListener {

            var name = binding.pName.text.toString()
            var price = binding.pPrice.text.toString()



            var stringRequest:StringRequest = object :StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/file/mobileinsert.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"Data Inserted",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity::class.java))

                },{

                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

                })
            {
                override fun getParams(): MutableMap<String, String>?
                {

                    var map = HashMap<String,String>()
                    map["product_name"]= name
                    map["product_price"]=price

                    return map
                }

            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)




        }




    }
}