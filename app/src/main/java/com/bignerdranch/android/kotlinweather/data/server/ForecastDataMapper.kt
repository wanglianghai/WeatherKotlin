package com.bignerdranch.android.kotlinweather.data.server

import com.bignerdranch.android.kotlinweather.domain.model.ForecastList
import com.bignerdranch.android.kotlinweather.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by Administrator on 2017/10/7/007.
 */
//把源数据转换成需要的数据
class ForecastDataMapper {
    //返回需要的数据
    fun convertFromDataModel(forecast: ForecastResult): ForecastList
            = ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    //传入源list返回转换list
    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>
            = list.map { convertForecastItemToDomain(it) } // 返回list

    //传入源数据Forecast 返回设置好需要的数据
    private fun convertForecastItemToDomain(forecast: Forecast) : ModelForecast
            = ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
            forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))

    //传入时间Long返回需要的日期格式
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    //传入图标名字返回对应的图标地址
    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}