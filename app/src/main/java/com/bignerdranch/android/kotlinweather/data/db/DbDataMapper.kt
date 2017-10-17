package com.bignerdranch.android.kotlinweather.data.db

import com.bignerdranch.android.kotlinweather.domain.model.Forecast
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList

/**
 * Created by Administrator on 2017/10/16/016.
 */
//到数据库中的city id对应这城市的forecast
//domain层的不需要
class DbDataMapper {
    //从domain转换成数据库的
    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, city, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    fun convertFromToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }
}