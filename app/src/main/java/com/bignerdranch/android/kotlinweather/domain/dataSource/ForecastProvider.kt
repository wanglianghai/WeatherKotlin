package com.bignerdranch.android.kotlinweather.domain.dataSource

import android.util.Log
import com.bignerdranch.android.kotlinweather.data.db.ForecastDb
import com.bignerdranch.android.kotlinweather.data.server.ForecastServer
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList
import com.bignerdranch.android.kotlinweather.extensions.firstResult

/**
 * Created by Administrator on 2017/10/17/017.
 */
//数据源：source 查询顺序先数据库在网络服务
class ForecastProvider(private val source: List<ForecastDataSource> = ForecastProvider.SOURCE) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCE = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int) : ForecastList =
            source.firstResult{requestSource(it, days, zipCode)}

    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long) : ForecastList?{
        Log.i("time: requestSources", todayTimeSpan().toString())
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}