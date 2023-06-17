package com.example.project123.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project123.databinding.ActivityCategoryBinding
import com.example.project123.databinding.ActivityFullScreenImageBinding
import com.squareup.picasso.Picasso

class FullScreenImageActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenImageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var image = i.getStringExtra("imageurl")

        Picasso.get().load(image).into(binding.photoView)


    }
}