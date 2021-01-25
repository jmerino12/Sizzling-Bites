package com.jmb.sizzlingbites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView

class IntroductoryActivity : AppCompatActivity() {
    private lateinit var logo:ImageView
    private lateinit var appName:ImageView
    private lateinit var splashImg:ImageView
    private lateinit var lottieAnimationView: LottieAnimationView

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

        splashImg.animate().translationY(-1600F).setDuration(1000).setStartDelay(4000)
        logo.animate().translationY(1400F).setDuration(1000).setStartDelay(4000)
        appName.animate().translationY(1400F).setDuration(1000).setStartDelay(4000)
        lottieAnimationView.animate().translationY(1400F).setDuration(1000).setStartDelay(4000)



    }
}