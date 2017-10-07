package com.bignerdranch.android.kotlinweather

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.bignerdranch.android.kotlinweather.domain.ForecastList

/**
 * Created by Administrator on 2017/10/7/007.
 */
class ForecastListAdapter(val weekForecast: ForecastList):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder!!.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
            = ViewHolder(TextView(parent!!.context))

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}