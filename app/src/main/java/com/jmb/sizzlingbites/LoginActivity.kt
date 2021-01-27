package com.jmb.sizzlingbites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var fb:FloatingActionButton
    lateinit var tw:FloatingActionButton
    lateinit var google:FloatingActionButton
    lateinit var loginAdapter: LoginAdapter
    private val kV:Float = 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)
        google = findViewById(R.id.fab_google)
        fb = findViewById(R.id.fab_facebook)
        tw = findViewById(R.id.fab_twi)

        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("SingUp"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        loginAdapter = LoginAdapter(this,tabLayout.tabCount,supportFragmentManager)
        viewPager.adapter = loginAdapter


        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        fb.translationY = 300F
        google.translationY = 300F
        tw.translationY = 300F
        tabLayout.translationY = 300F

        fb.alpha = kV
        google.alpha = kV
        tw.alpha = kV
        tabLayout.translationY = kV

        fb.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(400).start()
        google.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(600).start()
        tw.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(800).start()


    }
}