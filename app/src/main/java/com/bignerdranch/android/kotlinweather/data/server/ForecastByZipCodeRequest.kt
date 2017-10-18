package com.bignerdranch.android.kotlinweather.data.server

import com.google.gson.Gson
import java.net.URL
//基本网络请求
class ForecastByZipCodeRequest(val zipCode: Long, val gson: Gson = Gson()) {
    companion object {      //伴随对象
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URLs = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URLs}&APPID=${APP_ID}&q="
    }

    //由zipCode返回原始数据
    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}