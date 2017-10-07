package com.bignerdranch.android.kotlinweather

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Administrator on 2017/10/7/007.
 */
class ForecastListAdapter(val items: List<String>):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.textView.text = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
            = ViewHolder(TextView(parent!!.context))

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}