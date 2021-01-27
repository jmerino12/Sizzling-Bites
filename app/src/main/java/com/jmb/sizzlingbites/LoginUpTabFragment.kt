package com.jmb.sizzlingbites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LoginUpTabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login_tab_fragment, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                LoginUpTabFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

}