package com.example.mykotlinmediaplayer.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.example.mykotlinmediaplayer.R
import com.example.mykotlinmediaplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {

        super.initData()
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).duration = 2000
    }

    override fun onAnimationEnd(p0: View?) {
        startAndFinishAcitivy<MainActivity>()
    }

    override fun onAnimationStart(p0: View?) {

    }

    override fun onAnimationCancel(p0: View?) {
    }
}