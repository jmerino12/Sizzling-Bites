package com.jmb.sizzlingbites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView

class IntroductoryActivity : AppCompatActivity() {
    private lateinit var logo:ImageView
    private lateinit var appName:ImageView
    private lateinit var splashImg:ImageView
    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var anim:Animation

    var  NUM_PAGER:Int = 3
    private lateinit var viewPager: ViewPager
    private lateinit var onBoardingPager:ScreendSlidePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        //FULL WINDOW
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introductory)

        logo = findViewById(R.id.logo)
        appName = findViewById(R.id.app_name)
        splashImg = findViewById(R.id.img)
        lottieAnimationView = findViewById(R.id.lottie)

        viewPager = findViewById(R.id.pager)
        onBoardingPager = ScreendSlidePagerAdapter(supportFragmentManager)
        viewPager.adapter = onBoardingPager

        anim = AnimationUtils.loadAnimation(this,R.anim.o_b_animation)
        viewPager.startAnimation(anim)

        splashImg.animate().translationY(-1600F).setDuration(1000).setStartDelay(4000)
        logo.animate().translationY(1400F).setDuration(1000).setStartDelay(4000)
        appName.animate().translationY(1400F).setDuration(1000).setStartDelay(4000)
        lottieAnimationView.animate().translationY(1400F).setDuration(1000).setStartDelay(4000)
    }

    private class ScreendSlidePagerAdapter(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int {
            return  3
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> { return OnBoardingFragment1.newInstance()}
                1 -> { return OnBoardingFragment2.newInstance()}
                else -> { // Note the block
                    return OnBoardingFragment3.newInstance()
                }
            }
        }

    }
}