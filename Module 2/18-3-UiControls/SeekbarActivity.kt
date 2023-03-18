package com.example.uicontrolsex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.uicontrolsex.databinding.ActivityMainBinding
import com.example.uicontrolsex.databinding.ActivitySeekbarBinding

class SeekbarActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var binding: ActivitySeekbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekbarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.seek1.setOnSeekBarChangeListener(this)
        binding.seek2.setOnSeekBarChangeListener(this)
        binding.seek3.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
    {

        var r=binding.seek1.progress
        var g=binding.seek2.progress
        var b=binding.seek3.progress


        binding.img.setBackgroundColor(Color.rgb(r,g,b))




    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}