package com.example.mykotlinmediaplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.mykotlinmediaplayer.R
import com.example.mykotlinmediaplayer.adapter.HomeAdapter
import com.example.mykotlinmediaplayer.base.BaseFragment
import com.example.mykotlinmediaplayer.util.ThreadUtil
import com.example.mykotlinmediaplayer.util.URLProviderUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment : BaseFragment() {
    private val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        super.initListener()
        recycleView.layoutManager = LinearLayoutManager(context)

        recycleView.adapter = adapter
    }

    override fun initData() {
        super.initData()
        loadDatas()
    }

    private fun loadDatas() {
        val path = URLProviderUtils.getHomeUrl(0, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                myToast("获取数据失败")
            }

            override fun onResponse(call: Call, response: Response) {
                myToast("获取数据成功")
                val result = response.body()?.string()
                val list = Gson().fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        adapter.updateList(list)
                    }

                })
            }

        })
    }
}