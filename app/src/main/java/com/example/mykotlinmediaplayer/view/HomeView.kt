package com.example.mykotlinmediaplayer.view

import com.itheima.player.model.bean.HomeItemBean

interface HomeView {
    fun onError(message: String?)

    fun loadSuccess(list: List<HomeItemBean>?)

    fun loadMore(list: List<HomeItemBean>?)

}