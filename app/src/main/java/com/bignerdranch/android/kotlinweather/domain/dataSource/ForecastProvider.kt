package com.bignerdranch.android.kotlinweather.domain.dataSource

import android.util.Log
import com.bignerdranch.android.kotlinweather.data.db.ForecastDb
import com.bignerdranch.android.kotlinweather.data.server.ForecastServer
import com.bignerdranch.android.kotlinweather.domain.model.Forecast
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList
import com.bignerdranch.android.kotlinweather.extensions.firstResult

/**
 * Created by Administrator on 2017/10/17/017.
 */
//数据源：source 查询顺序先数据库在网络服务
//数据提供类
class ForecastProvider(private val source: List<ForecastDataSource> = ForecastProvider.SOURCE) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCE = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList =
            source.firstResult{requestToSource { it.requestForecastByZipCode(zipCode, todayTimeSpan()) }}

    fun requestForecast(id: Long): Forecast = requestToSource { it.requestDayForecast(id) }

    private fun <T: Any> requestToSource(f: (ForecastDataSource) -> T?): T
            = source.firstResult { f(it) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}