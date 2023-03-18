package com.example.uicontrolsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uicontrolsex.databinding.ActivityFeedbackBinding
import com.example.uicontrolsex.databinding.ActivityMainBinding

class FeedbackActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.edtname.setText("Prakruti")



    }
}