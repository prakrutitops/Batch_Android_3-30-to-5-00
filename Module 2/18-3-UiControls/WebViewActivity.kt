package com.example.uicontrolsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uicontrolsex.databinding.ActivityFeedbackBinding
import com.example.uicontrolsex.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.web.loadUrl("https://www.tops-int.com")




    }
}