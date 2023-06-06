package com.example.advertisments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.formats.AdManagerAdViewOptions

class MainActivity : AppCompatActivity()
{
    lateinit var adview:AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adview = findViewById(R.id.adView)
        val adRequest: AdRequest = AdRequest.Builder().build()
        adview.loadAd(adRequest)


    }
}