package com.bignerdranch.android.kotlinweather.data.server

import com.bignerdranch.android.kotlinweather.data.db.ForecastDb
import com.bignerdranch.android.kotlinweather.domain.dataSource.ForecastDataSource
import com.bignerdranch.android.kotlinweather.domain.dataSource.ForecastProvider
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList

/**
 * Created by Administrator on 2017/10/17/017.
 */
//网络服务
class ForecastServer(private val serverDataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    //它在从服务端接收到数据之后就会使用 ForecastDb 去保存到数据库,在取出
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = serverDataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }
}