package com.example.anautomaticslider

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.util.ArrayList


class SliderFragment : Fragment() {

    var imageView: ImageView? = null
    var listItems: ArrayList<SlideItemsModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Make a copy of the slides you'll be presenting.
        listItems.add(SlideItemsModel(R.drawable.item1))
        listItems.add(SlideItemsModel(R.drawable.item2))
        listItems.add(SlideItemsModel(R.drawable.item3))
        listItems.add(SlideItemsModel(R.drawable.item4))

        if (arguments != null) {

            //Log.e("myTag", "${requireArguments().get("param1")}")
            Log.e("myTag", "${listItems.get(requireArguments().get("param1") as Int)}")

            imageView?.setImageResource(listItems.get(requireArguments().get("param1") as Int).image)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_slider, container, false)

        imageView = view.findViewById(R.id.my_featured_image)

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Int) =
            SliderFragment().apply {
                arguments = Bundle().apply {
                    this.putInt("param1", param1)
                }
            }
    }
}