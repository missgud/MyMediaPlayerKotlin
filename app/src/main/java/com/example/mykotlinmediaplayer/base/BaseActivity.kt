package com.example.mykotlinmediaplayer.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mykotlinmediaplayer.ui.activity.MainActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initListener()
    }

    open protected fun initData() {

    }

    open protected fun initListener() {

    }

    abstract fun getLayoutId(): Int

    open protected fun myToast(msg: String) {
        runOnUiThread { toast(msg) }
    }

    protected inline fun <reified T : BaseActivity> startAndFinishAcitivy(){
        startActivity<T>()
        finish()
    }
}