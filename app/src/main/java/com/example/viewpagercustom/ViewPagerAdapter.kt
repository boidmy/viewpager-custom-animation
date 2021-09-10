package com.example.viewpagercustom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.pager_item.view.*

class ViewPagerAdapter : RecyclerView.Adapter<ViewHolder>() {

    var list: ArrayList<Int> = arrayListOf()
    init {
        list.add(R.drawable.img1)
        list.add(R.drawable.img2)
        list.add(R.drawable.img3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pager_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return 3
    }
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindView(url: Int) {
        Glide.with(itemView.context)
            .load(url)
            .into(itemView.img)
    }
}