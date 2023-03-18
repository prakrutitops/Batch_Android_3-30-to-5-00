package com.example.uicontrolsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import com.example.uicontrolsex.databinding.ActivityMainBinding
import com.example.uicontrolsex.databinding.ActivityRatingbarBinding

class RatingbarActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {
    private lateinit var binding: ActivityRatingbarBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingbarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rate.setOnRatingBarChangeListener(this)
    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean)
    {
            Toast.makeText(applicationContext,""+ ratingBar!!.rating,Toast.LENGTH_LONG).show()
    }
}