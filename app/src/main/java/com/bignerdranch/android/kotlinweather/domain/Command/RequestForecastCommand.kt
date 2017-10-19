package com.bignerdranch.android.kotlinweather.domain.Command

import com.bignerdranch.android.kotlinweather.data.server.ServerDataMapper
import com.bignerdranch.android.kotlinweather.data.server.ForecastByZipCodeRequest
import com.bignerdranch.android.kotlinweather.domain.dataSource.ForecastProvider
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList

/**
 * Created by Administrator on 2017/10/7/007.
 */
//得到需要数据
class RequestForecastCommand(private val zipCode: Long,
                             private val forecastProvider: ForecastProvider = ForecastProvider()): Command<ForecastList> {
    companion object {
        val DAYS = 7
    }

    override fun execute()
            = forecastProvider.requestByZipCode(zipCode, DAYS)
}