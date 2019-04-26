package com.example.mykotlinmediaplayer.util

import com.example.mykotlinmediaplayer.R
import com.example.mykotlinmediaplayer.base.BaseFragment
import com.example.mykotlinmediaplayer.ui.fragment.HomeFragment
import com.example.mykotlinmediaplayer.ui.fragment.MVFragment
import com.example.mykotlinmediaplayer.ui.fragment.VBangFragment
import com.example.mykotlinmediaplayer.ui.fragment.YueDanFragment

class FragmentUtil private constructor() {
    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MVFragment() }
    val vBangFragment by lazy { VBangFragment() }
    val yueDanFragment by lazy { YueDanFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    fun getFragment(tabId: Int): BaseFragment? {
        return when (tabId) {
            R.id.navigation_workbench -> homeFragment
            R.id.navigation_dial -> mvFragment
            R.id.navigation_contacts -> vBangFragment
            R.id.navigation_user_info -> yueDanFragment
            else -> null
        }
    }
}