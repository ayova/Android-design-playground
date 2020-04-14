package com.example.dia4

import android.graphics.BlurMaskFilter
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.giphy)
        video_main.setVideoURI(uri)
        video_main.start()

        video_main.setOnCompletionListener {
            video_main.start()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportFragmentManager.beginTransaction().add(R.id.frame_main,BeginFragment()).commit()
    }

    // note - onResume implemented to avoid static black background
    override fun onResume() {
        var uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.giphy)
        video_main.setVideoURI(uri)
        video_main.start()
        super.onResume()
    }

//    override fun onBackPressed() {
//        val count = supportFragmentManager?.backStackEntryCount
//        if (count > 0) {
//            supportFragmentManager.popBackStack()
//        }
//    }

    interface fOnBackPressed{
        fun onBackPressed():Boolean
    }

    override fun onBackPressed() {
        val fragment =
            this.supportFragmentManager.findFragmentById(R.id.frame_main)
        (fragment as? fOnBackPressed)?.onBackPressed()?.not()?.let {
            super.onBackPressed()
        }
    }
}
