package com.example.mykotlinmediaplayer.util

import android.content.Intent
import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.example.mykotlinmediaplayer.R
import com.example.mykotlinmediaplayer.ui.activity.SettingActivity

interface ToolBarManager {
    val toolBar: Toolbar

    fun initMainToolbar() {
        toolBar.title = "黑马影音"
        toolBar.inflateMenu(R.menu.setting)
        toolBar.setOnMenuItemClickListener {
            toolBar.context.startActivity(Intent(toolBar.context, SettingActivity::class.java))
            true
        }
//        toolBar.setOnMenuItemClickListener { item ->
//            when (item.itemId) {
//                R.id.setting -> toolBar.context.startActivity(Intent(toolBar.context,SettingActivity::class.java))
//            }
//            true
//        }
    }

    fun initSettingToolbar() {
        toolBar.title = "设置界面"
        val sp = PreferenceManager.getDefaultSharedPreferences(toolBar.context)
        val push = sp.getBoolean("push",false)
        println("push : $push")
    }
}