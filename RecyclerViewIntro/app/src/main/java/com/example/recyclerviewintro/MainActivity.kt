package com.example.recyclerviewintro

import MainRecyclerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), customItemListener {

    var demoNames = listOf(
        "Jamey Bush","Casandra Red", "Melvin Detrick", "Mirella Jiggetts","Brook Hetzel",
        "Eva Mccrystal","Glennie Hiott", "Alverta Ruggles", "Floria Pedroza", "Marianela Redman",
        "Colby Bellew", "Marquerite Kite", "Marcelene Rhoads", "Taneka Burgin",
        "Marci Smits","Michelle Madero", "Pinkie Josey", "Marlys Nieman","Ling Reddick"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = MainRecyclerAdapter(demoNames, this)
        main_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_recycler.adapter = mAdapter
    }

    override fun onItemClick(name: String, postion: Int) {
        Log.v("tryme","El nombre $name está en la posición $postion")
    }
}
