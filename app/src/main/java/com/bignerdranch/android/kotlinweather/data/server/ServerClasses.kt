package com.bignerdranch.android.kotlinweather.data.server


/**
 * Created by Administrator on 2017/10/11/011.
 */
//原始数据的字段
data class City(val id: Long, val name: String, val coordinates: Coordinates,
                val country: String, val population: Int)

data class Coordinates(val lon: Float, val lat: Float)

data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

data class ForecastResult(val city: City, val list: List<Forecast>)

data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String,
                   val icon: String)