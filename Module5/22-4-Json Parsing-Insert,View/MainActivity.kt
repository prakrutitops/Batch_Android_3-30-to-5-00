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
import com.example.insertdata.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()


        var stringRequest = StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/file/mobile.php",object : Response.Listener<String>{
            override fun onResponse(response: String?)
            {

                var jsonarray = JSONArray(response)

                for(i in 0 until jsonarray.length())
                {
                    var jsonObject2 = jsonarray.getJSONObject(i)

                    var name = jsonObject2.getString("product_name")
                    var price = jsonObject2.getString("product_price")

                    var m = Model()
                    m.name=name
                    m.price=price
                    list.add(m)
                }

                var adapter = MyAdapter(applicationContext,list)
                binding.list.adapter = adapter
            }
        })
        {
            Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
        }
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)


        binding.f1.setOnClickListener {

                startActivity(Intent(applicationContext,AddUserActivity::class.java))


        }




    }
}