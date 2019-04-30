package com.example.mykotlinmediaplayer.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.mykotlinmediaplayer.R
import com.example.mykotlinmediaplayer.adapter.HomeAdapter
import com.example.mykotlinmediaplayer.base.BaseFragment
import com.example.mykotlinmediaplayer.presenter.impl.HomePresenterImpl
import com.example.mykotlinmediaplayer.presenter.interf.HomePresenter
import com.example.mykotlinmediaplayer.util.ThreadUtil
import com.example.mykotlinmediaplayer.util.URLProviderUtils
import com.example.mykotlinmediaplayer.view.HomeView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.jetbrains.anko.support.v4.onRefresh
import java.io.IOException

class HomeFragment : BaseFragment(), HomeView {


    private val adapter by lazy {
        HomeAdapter()
    }

    private val presenter by lazy {
        HomePresenterImpl(this)
    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        super.initListener()
        recycleView.layoutManager = LinearLayoutManager(context)

        recycleView.adapter = adapter
        // 初始化刷新控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        refreshLayout.onRefresh { presenter.loadDatas() }
        // 监听列表滑动
        recycleView.setOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                // 如果是停止状态
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 而且是线性布局
                    if (recyclerView.layoutManager is LinearLayoutManager) {

                        val manager = recyclerView.layoutManager as LinearLayoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()

                        // 如果最后一条显示
                        if (lastPosition == adapter.itemCount - 1) {
                            presenter.loadMore(adapter.itemCount - 1)
                        }
                    }

                }
            }
        })

    }

    override fun initData() {
        super.initData()
        presenter.loadDatas()
    }
    override fun onError(message: String?) {
        myToast("加载数据失败")
    }

    override fun loadSuccess(list: List<HomeItemBean>?) {
        refreshLayout.isRefreshing = false
        adapter.updateList(list)
    }

    override fun loadMore(list: List<HomeItemBean>?) {
        list?.let { adapter.loadMore(it) }
    }
}