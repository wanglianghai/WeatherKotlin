package com.bignerdranch.android.kotlinweather.domain.model

/**
 * Created by Administrator on 2017/10/11/011.
 */
//需要的数据类型
data class Forecast(val date: Long, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)

data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast:List<Forecast>) {
    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}