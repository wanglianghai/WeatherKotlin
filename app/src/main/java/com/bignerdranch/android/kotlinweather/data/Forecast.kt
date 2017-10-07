package com.bignerdranch.android.kotlinweather.data

/**
 * Created by Administrator on 2017/10/7/007.
 */
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int, val rain: Float)
