package com.bignerdranch.android.kotlinweather.domain

import com.bignerdranch.android.kotlinweather.data.Forecast
import com.bignerdranch.android.kotlinweather.domain.Forecast as ModelForecast
import com.bignerdranch.android.kotlinweather.data.ForecastResult
import java.text.DateFormat
import java.util.*

/**
 * Created by Administrator on 2017/10/7/007.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList
            = ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>
            = list.map { convertForecastItemToDomain(it) }

    private fun convertForecastItemToDomain(forecast: Forecast) : ModelForecast
            = ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
            forecast.temp.max.toInt(), forecast.temp.min.toInt())

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}