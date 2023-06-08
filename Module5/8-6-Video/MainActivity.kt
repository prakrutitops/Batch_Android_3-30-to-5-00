package com.example.videoplay

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.vd)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val video: Uri = Uri.parse("xyz")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(video)
        videoView.start()
    }
}