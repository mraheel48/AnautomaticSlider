package com.example.anautomaticslider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.anautomaticslider.SliderFragment.Companion.newInstance

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return newInstance(position)
    }

    override fun getItemCount(): Int {
        return CARD_ITEM_SIZE
    }

    companion object {
        private const val CARD_ITEM_SIZE = 4
    }
}