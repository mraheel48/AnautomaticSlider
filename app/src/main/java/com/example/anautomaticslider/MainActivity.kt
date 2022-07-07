package com.example.anautomaticslider

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.util.*

class MainActivity : AppCompatActivity() {

    var listItems: ArrayList<SlideItemsModel> = ArrayList()

    public lateinit var tabLayout: TabLayout
    public lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)

        // Make a copy of the slides you'll be presenting.
        listItems.add(SlideItemsModel(R.drawable.item1))
        listItems.add(SlideItemsModel(R.drawable.item2))
        listItems.add(SlideItemsModel(R.drawable.item3))
        listItems.add(SlideItemsModel(R.drawable.item4))
        /*listItems.add(SlideItemsModel(R.drawable.item5))
        listItems.add(SlideItemsModel(R.drawable.item6))
        listItems.add(SlideItemsModel(R.drawable.item7))
        listItems.add(SlideItemsModel(R.drawable.item8))
        listItems.add(SlideItemsModel(R.drawable.item9))
        listItems.add(SlideItemsModel(R.drawable.item10))*/

        Log.d("myTag", "${listItems.size}")
        viewPager.adapter = SlidePagerAdapter(listItems)

        // The_slide_timer
        val timer = Timer()
        timer.schedule(TheSliderTimer(this, viewPager, listItems), 2000, 3000)
        tabLayout.setupWithViewPager(viewPager, true)

    }

    class TheSliderTimer(
        val activity: AppCompatActivity,
        val viewPager: ViewPager,
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