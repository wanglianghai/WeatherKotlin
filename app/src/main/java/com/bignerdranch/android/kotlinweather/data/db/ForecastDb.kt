package com.bignerdranch.android.kotlinweather.data.db

import com.bignerdranch.android.kotlinweather.domain.model.ForecastList
import com.bignerdranch.android.kotlinweather.extensions.clear
import com.bignerdranch.android.kotlinweather.extensions.parseList
import com.bignerdranch.android.kotlinweather.extensions.parseOpt
import com.bignerdranch.android.kotlinweather.extensions.toVararArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by Administrator on 2017/10/16/016.
 */
class ForecastDb(private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 private val dataMapper: DbDataMapper = DbDataMapper()) {
    fun requestForecastFromByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME).
                whereSimple(dailyRequest, zipCode.toString(), date.toString()).
                parseList{DayForecast(HashMap(it))}
        val city = select(CityForecastTable.NAME).
                whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt{CityForecast(HashMap(it), dailyForecast)}

        if (city != null) dataMapper.convertFromToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(DayForecastTable.NAME)
        clear(CityForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVararArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVararArray()) }
        }
    }
}