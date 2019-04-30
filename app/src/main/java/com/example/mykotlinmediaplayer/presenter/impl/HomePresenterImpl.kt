package com.example.mykotlinmediaplayer.presenter.impl

import com.example.mykotlinmediaplayer.presenter.interf.HomePresenter
import com.example.mykotlinmediaplayer.util.ThreadUtil
import com.example.mykotlinmediaplayer.util.URLProviderUtils
import com.example.mykotlinmediaplayer.view.HomeView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomePresenterImpl(var homeView: HomeView) : HomePresenter {
    override fun loadDatas() {
        val path = URLProviderUtils.getHomeUrl(0, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // 隐藏刷新进度条
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.onError(e.message)
                    }

                })

            }

            override fun onResponse(call: Call, response: Response) {
                // 隐藏刷新进度条

                val result = response.body()?.string()
                val list = Gson().fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.loadSuccess(list)
                    }

                })
            }

        })
    }

    override fun loadMore(offset: Int) {
        val path = URLProviderUtils.getHomeUrl(offset, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // 隐藏刷新进度条
                // 隐藏刷新进度条
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.onError(e.message)
                    }

                })

            }

            override fun onResponse(call: Call, response: Response) {
                // 隐藏刷新进度条

                val result = response.body()?.string()
                val list = Gson().fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.loadMore(list)
                    }

                })
            }

        })
    }


}