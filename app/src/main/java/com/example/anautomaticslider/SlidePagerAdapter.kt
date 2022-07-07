package com.example.anautomaticslider

import android.content.Context
import com.example.anautomaticslider.SlideItemsModel
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.anautomaticslider.R

class SlidePagerAdapter(

    private val theSlideItemsModelClassList: List<SlideItemsModel>
) : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater =
            container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val sliderLayout = inflater.inflate(R.layout.the_items_layout_new, null)
        val featured_image = sliderLayout.findViewById<ImageView>(R.id.my_featured_image)
        featured_image.setImageResource(theSlideItemsModelClassList[position].image)
        container.addView(sliderLayout)
        return sliderLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return theSlideItemsModelClassList.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }
}