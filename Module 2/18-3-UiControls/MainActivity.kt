package com.example.uicontrolsex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.example.uicontrolsex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)



    }

    override fun onClick(v: View?)
    {
        if(v==binding.btn1)
        {
            binding.pb.incrementProgressBy(1)
            setProgress(100*binding.pb.progress)
        }
        if(v==binding.btn2)
        {
            binding.pb.incrementProgressBy(-1)
            setProgress(100*binding.pb.progress)
        }
        }
    }
    /* fun tops(v: View?)
     {

     }*/
//}