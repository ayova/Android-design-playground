package com.example.woworkslidernav

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

        val myAdapter = object: FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        var bundle = Bundle()
                        var frag = PagerFragment.newInstance("consigue trabajo", "encuentra trabajo por" +
                                "todo el mundo mientras viajas", R.drawable.slide_one)
                        frag
                    }
                    1 -> {
                        var bundle = Bundle()
                        var frag = PagerFragment.newInstance("vive aventuras", "explora cientos de lugares" +
                                "sabiendo que siempre tendrás trabajo", R.drawable.slide_three)
                        frag
                    }
                    2 -> {
                        var bundle = Bundle()
                        var frag = PagerFragment.newInstance("gana dinero", "tendrás clientes por todas partes" +
                                "del mundo", R.drawable.slide_two)
                        frag
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
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = numOfPages

        override fun createFragment(position: Int): Fragment {
            return PagerFragment()
        }
    }
}
