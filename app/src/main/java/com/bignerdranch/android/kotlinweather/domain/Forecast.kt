package com.bignerdranch.android.kotlinweather.domain

/**
 * Created by Administrator on 2017/10/7/007.
 */
data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)