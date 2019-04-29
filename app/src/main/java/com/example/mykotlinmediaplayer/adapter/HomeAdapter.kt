package com.example.mykotlinmediaplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.mykotlinmediaplayer.weight.HomeItemView
import com.itheima.player.model.bean.HomeItemBean

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

    fun updateList(list:List<HomeItemBean>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        val data = list[position]
        val itemView = holder.itemView as HomeItemView

        itemView.setData(data)

    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}