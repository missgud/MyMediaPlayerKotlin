package com.example.mykotlinmediaplayer.weight

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.mykotlinmediaplayer.R
import com.itheima.player.model.bean.HomeItemBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView : RelativeLayout {



    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_home,this)
    }

    fun setData(data: HomeItemBean) {
        title.text = data.title
        desc.text = data.description
        Picasso.with(context).load(data.posterPic).into(bg)
    }
}