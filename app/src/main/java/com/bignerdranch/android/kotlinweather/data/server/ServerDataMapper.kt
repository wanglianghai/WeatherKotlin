package com.bignerdranch.android.kotlinweather.data.server

import android.util.Log
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList
import com.bignerdranch.android.kotlinweather.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/10/7/007.
 */
//把源数据转换成需要的数据
class ServerDataMapper {
    //返回需要的数据
    fun convertToDomain(zipCode: Long, forecast: ForecastResult): ForecastList
            = ForecastList(zipCode, forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    //传入源list返回转换list
    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            //系统时间
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            Log.i("time: dt", "$dt")
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    } // 返回list

    //传入源数据Forecast 返回设置好需要的数据
    private fun convertForecastItemToDomain(forecast: Forecast) : ModelForecast = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }
    //传入时间Long返回需要的日期格式
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    //传入图标名字返回对应的图标地址
    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}