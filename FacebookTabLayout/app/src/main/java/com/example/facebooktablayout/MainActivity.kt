package com.example.facebooktablayout

import TabAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation = 0.0f

        // Creamos el adapter con los fragments que querremos utilizar
        val myAdapter = TabAdapter(supportFragmentManager)
        myAdapter.addFragment(HomeFragment(), "")
        myAdapter.addFragment(VideosFragment(), "")
        myAdapter.addFragment(PeopleFragment(),"")
        myAdapter.addFragment(NotificationsFragment(), "")
        myAdapter.addFragment(SettingsFragment(), "")
        // Instanciamos el ViewPager con el Adapter creado
        main_viewPager.adapter = myAdapter
        // Asignamos el viewPager al TabLayout para que cambie cuando hacemos swipe
        main_tabLayout.setupWithViewPager(main_viewPager)
        // Asignamos iconos a los tabs
        main_tabLayout.getTabAt(0)?.icon = getDrawable(R.drawable.ic_home_white_24dp) // home
        main_tabLayout.getTabAt(1)?.icon = getDrawable(R.drawable.ic_ondemand_video_white_24dp) // video
        main_tabLayout.getTabAt(2)?.icon = getDrawable(R.drawable.ic_people_white_24dp) // people
        main_tabLayout.getTabAt(3)?.icon = getDrawable(R.drawable.ic_notifications_white_24dp) // notifications
        main_tabLayout.getTabAt(4)?.icon = getDrawable(R.drawable.ic_menu_black_24dp) // settings

        var badge = main_tabLayout.getTabAt(3)?.orCreateBadge as BadgeDrawable
        badge.setVisible(true)
        badge.number = 10
    }
}
