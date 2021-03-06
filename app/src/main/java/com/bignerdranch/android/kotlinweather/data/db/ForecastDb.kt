package com.bignerdranch.android.kotlinweather.data.db

import com.bignerdranch.android.kotlinweather.domain.dataSource.ForecastDataSource
import com.bignerdranch.android.kotlinweather.domain.model.Forecast
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList
import com.bignerdranch.android.kotlinweather.extensions.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by Administrator on 2017/10/16/016.
 */
//数据库查询和保存
class ForecastDb(private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 private val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

    //id->一天
    override fun requestDayForecast(id: Long): Forecast? = forecastDbHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id).parseOpt { DayForecast(HashMap(it)) }
        if (forecast != null) dataMapper.convertDayToDomain(forecast) else null
    }

    //库取结果
    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME).
                whereSimple(dailyRequest, zipCode.toString(), date.toString()).
                parseList{DayForecast(HashMap(it))}

        val city = select(CityForecastTable.NAME).
                whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt{CityForecast(HashMap(it), dailyForecast)}

        if (city != null) dataMapper.convertFromToDomain(city) else null
    }

    //库存结果
    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(DayForecastTable.NAME)
        clear(CityForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVararArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVararArray()) }
        }
    }
}