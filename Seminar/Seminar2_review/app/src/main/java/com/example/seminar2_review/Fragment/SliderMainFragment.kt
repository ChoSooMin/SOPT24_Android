package com.example.seminar2_review.Fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.seminar2_review.R
import kotlinx.android.synthetic.main.fragment_slider_main.*

class SliderMainFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val color:Int = arguments!!.getInt("background_color")
//        img_fragment_slider_main.setBackgroundColor(color) // 색상으로 채우기

        // 인터넷에서 이미지 가져와서 띄우기
        Glide.with(this)
            .load("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045")
            .into(img_fragment_slider_main)
    }
}



