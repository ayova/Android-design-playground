package com.example.whatsapptablayout

import TabAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.elevation = 0.0f
        supportActionBar?.title = "WhatsApp"

        // Creamos el adapter con los fragments que querremos utilizar
        val myAdapter = TabAdapter(supportFragmentManager)
        myAdapter.addFragment(CallsFragment(), "Calls")
        myAdapter.addFragment(ChatsFragment(), "Chats")
        myAdapter.addFragment(ContactsFragment(),"Contacts")
        // Instanciamos el ViewPager con el Adapter creado
        main_viewPager.adapter = myAdapter
        // Asignamos el viewPager al TabLayout para que cambie cuando hacemos swipe
        main_tabLayout.setupWithViewPager(main_viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
