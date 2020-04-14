package com.example.dia_4_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.synnapps.carouselview.ImageClickListener
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import kotlinx.android.synthetic.main.toolbar_main.toolbar_main

class MainActivity : AppCompatActivity() {

    var sampleImages = arrayListOf<Int>(R.drawable.hotel_room0,R.drawable.hotel_room1,R.drawable.hotel_room2,R.drawable.hotel_room3)
    val imageListener = ImageListener { position, imageView ->  
        imageView.setImageResource(sampleImages[position])
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // action bar (toolbar) set up
        setSupportActionBar(toolbar_main)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // image carousel set up
        carouselView_main.pageCount = sampleImages.size
        carouselView_main.setImageListener(imageListener)

        btn_back.setOnClickListener{
            Toast.makeText(applicationContext, "Pressed back button", Toast.LENGTH_SHORT)
        }

        btn_share.setOnClickListener{
            Toast.makeText(applicationContext, "Pressed share button", Toast.LENGTH_SHORT)
        }

        btn_heart.setOnClickListener{
            Toast.makeText(applicationContext, "Pressed heart button", Toast.LENGTH_SHORT)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
