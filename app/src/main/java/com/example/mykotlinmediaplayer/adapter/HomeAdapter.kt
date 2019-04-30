package com.example.mykotlinmediaplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.mykotlinmediaplayer.weight.HomeItemView
import com.example.mykotlinmediaplayer.weight.LoadMoreView
import com.itheima.player.model.bean.HomeItemBean

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

    fun updateList(list: List<HomeItemBean>?) {

        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }

    }
    fun loadMore(list: List<HomeItemBean>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if (viewType == 1) {
            return HomeHolder(LoadMoreView(parent.context))
        } else {
            return HomeHolder(HomeItemView(parent.context))
        }

    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        // 如果是最后一条不刷新数据
        if(position == list.size) return
        val data = list[position]
        val itemView = holder.itemView as HomeItemView

        itemView.setData(data)

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size) 1 else 0
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}