package com.example.woworkslidernav

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pager.*
import me.relex.circleindicator.CircleIndicator3
import java.lang.Error

private const val numOfPages = 3

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_main_skip.background.setTintList(getColorStateList(R.color.skip_btn))

//        val pagerAdapter = ScreenSlidePagerAdapter(this)
//        main_viewPager2.adapter = pagerAdapter

        val myAdapter = object: FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        PagerFragment()
                    }
                    1 -> {
                        PagerFragment1()
                    }
                    2 -> {
                        PagerFragment2()
                    }
                    else -> {
                        PagerFragment()
                    }
                }
            }
            override fun getItemCount(): Int {
                return numOfPages
            }
        }
        main_viewPager2.adapter = myAdapter
        fragment_pager_indicator.setViewPager(main_viewPager2)

        btn_main_skip.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }

}
