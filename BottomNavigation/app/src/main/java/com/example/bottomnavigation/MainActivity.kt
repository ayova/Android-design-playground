package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import org.intellij.lang.annotations.JdkConstants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager2Adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        RedFragment()
                    }
                    1 -> {
                        GreenFragment()
                    }
                    2-> {
                        BlueFragment()
                    }
                    else -> {
                        RedFragment()
                    }
                }
            }
            override fun getItemCount(): Int {
                return 3
            }
        }
        main_viewpager2.adapter = pager2Adapter

        main_viewpager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> {
                        main_bottom_navigation.selectedItemId = R.id.action_red
                    }
                    1 -> {
                        main_bottom_navigation.selectedItemId = R.id.action_green
                    }
                    2 -> {
                        main_bottom_navigation.selectedItemId = R.id.action_blue
                    }
                    else -> {
                        main_bottom_navigation.selectedItemId = R.id.action_red
                    }
                }
            }
        })

        main_bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_red -> {
                    main_viewpager2.currentItem = 0
                    true
                }
                R.id.action_green -> {
                    main_viewpager2.currentItem = 1
                    true
                }
                R.id.action_blue -> {
                    main_viewpager2.currentItem = 2
                    true
                }
                else -> {
                    main_viewpager2.currentItem = 0
                    true
                }
            }
        }

    }
}
