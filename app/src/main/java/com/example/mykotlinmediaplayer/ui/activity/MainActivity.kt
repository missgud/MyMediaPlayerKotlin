package com.example.mykotlinmediaplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.example.mykotlinmediaplayer.R
import com.example.mykotlinmediaplayer.base.BaseActivity
import com.example.mykotlinmediaplayer.util.FragmentUtil
import com.example.mykotlinmediaplayer.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find


class MainActivity : BaseActivity(), ToolBarManager {
    override val toolBar: Toolbar by lazy { find<Toolbar>(R.id.tool_bar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        super.initData()
        initMainToolbar()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(R.id.navigation_workbench)!!, R.id.navigation_workbench
            .toString())
        transaction.commit()
    }

    override fun initListener() {
        super.initListener()
//        bottomBar.setOnTabSelectListener {
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it)!!,it.toString())
//            transaction.commit()
//        }
        bottomNavigationView.setOnNavigationItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it.itemId)!!, it.toString())
            transaction.commit()
            true
        }
    }
}



