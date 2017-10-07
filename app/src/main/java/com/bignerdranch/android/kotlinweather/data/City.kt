package com.bignerdranch.android.kotlinweather.data

/**
 * Created by Administrator on 2017/10/7/007.
 */
data class City(val id: Long, val name: String, val coordinates: Coordinates,
                val country: String, val population: Int)