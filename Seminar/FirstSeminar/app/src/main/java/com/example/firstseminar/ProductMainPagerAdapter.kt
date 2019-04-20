package com.example.firstseminar

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ProductMainPagerAdapter(fm: FragmentManager, private val num_fragment : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? { // 이 함수는 null 값을 리턴하기도 한다는 뜻에서 ?를 붙여줌
        return when(p0) {
            0 -> AllProductMainFragment()
            1 -> NewProductMainFragment()
            2 -> EndProductMainFragment()

            else -> null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }
}