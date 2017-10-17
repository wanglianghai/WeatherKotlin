package com.bignerdranch.android.kotlinweather.data.server

import com.google.gson.Gson
import java.net.URL

//伴随类，返回原始数据
class ForecastRequest(val zipCode: Long) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URLs = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URLs}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}