package com.example.sliderex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.sliderex.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    var map = HashMap<String,Int>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        map.put("Image1",R.drawable.a)
        map.put("Image2",R.drawable.abc)
        map.put("Image3",R.drawable.photo)

      for(name in map.keys)
      {
          var textslider = TextSliderView(this)
          textslider
              .description(name)//name
              .image(map.get(name)!!)//image
              .setScaleType(BaseSliderView.ScaleType.Fit)

          binding.slider.setPresetTransformer(SliderLayout.Transformer.ZoomIn)
          binding.slider.setDuration(2000)
          binding.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
          binding.slider.addSlider(textslider)

      }




    }
}