package com.jmb.sizzlingbites

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by jmerino on 1/27/21
 */
class LoginAdapter(context: Context, totalTabs:Int,fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private  val totalTab: Int = totalTabs
    override fun getCount(): Int {
        return totalTab
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> { return LoginUpTabFragment.newInstance()}
            else -> { // Note the block
                return SingUpTabFragment.newInstance()
            }
        }
    }
}