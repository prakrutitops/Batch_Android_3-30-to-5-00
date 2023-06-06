package com.example.myapplication

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.ln

class MainActivity : AppCompatActivity()
{
    val apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var stringRequest = StringRequest(Request.Method.GET,apiUrl,
            {response->
                try
                {
                    var jsonObject = JSONObject(response)


                    var lat = jsonObject.getString("latitude")
                    var lng = jsonObject.getString("longitude")
                    var gen = jsonObject.getString("generationtime_ms")
                    var utc = jsonObject.getString("utc_offset_seconds")

                    var jsonObject2 = jsonObject.getString("hourly_units")

                    Toast.makeText(applicationContext,""+jsonObject2.toString(),Toast.LENGTH_LONG).show()
                    Toast.makeText(applicationContext," "+lat+" "+ lng+" "+gen+" "+utc,Toast.LENGTH_LONG).show()

                }
                catch (e:JSONException)
                {


                    Toast.makeText(applicationContext,""+e.message,Toast.LENGTH_LONG).show()


                }
            }

                )
        {
            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
        }

        val queue: RequestQueue = Volley.newRequestQueue(applicationContext)
        queue.add(stringRequest)




    }

}