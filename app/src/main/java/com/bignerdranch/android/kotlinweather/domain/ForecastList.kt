package com.bignerdranch.android.kotlinweather.domain

/**
 * Created by Administrator on 2017/10/7/007.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>)