package com.jmb.sizzlingbites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class OnBoardingFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding1, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                OnBoardingFragment1().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

}