package com.example.mykotlinmediaplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.example.mykotlinmediaplayer.R
import com.example.mykotlinmediaplayer.base.BaseActivity
import com.example.mykotlinmediaplayer.util.ToolBarManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(),ToolBarManager {
    override val toolBar by lazy { find<Toolbar>(R.id.tool_bar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        super.initData()
        initSettingToolbar()
    }

}
