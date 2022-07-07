package com.example.anautomaticslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class SecondTry : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    var listItems: ArrayList<SlideItemsModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_try)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)

        // Make a copy of the slides you'll be presenting.
        listItems.add(SlideItemsModel(R.drawable.item1))
        listItems.add(SlideItemsModel(R.drawable.item2))
        listItems.add(SlideItemsModel(R.drawable.item3))
        listItems.add(SlideItemsModel(R.drawable.item4))

        viewPager.adapter = createCardAdapter()
        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position -> /*tab.text = "Tab " + (position + 1)*/ }.attach()

        // The_slide_timer
        val timer = Timer()
        timer.schedule(TheSliderTimer(this, viewPager, listItems), 2000, 3000)
    }

    private fun createCardAdapter(): ViewPagerAdapter {
        return ViewPagerAdapter(this)
    }


    class TheSliderTimer(
        val activity: AppCompatActivity,
        val viewPager: ViewPager2,
        val listItem: ArrayList<SlideItemsModel>
    ) : TimerTask() {
        override fun run() {
            activity.runOnUiThread {
                if (viewPager.currentItem < listItem.size - 1) {
                    viewPager.currentItem = viewPager.currentItem + 1;
                } else
                    viewPager.currentItem = 0;
            }
        }
    }
}