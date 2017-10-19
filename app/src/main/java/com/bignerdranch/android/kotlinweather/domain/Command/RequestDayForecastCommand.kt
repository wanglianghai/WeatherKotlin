package com.bignerdranch.android.kotlinweather.domain.Command

import com.bignerdranch.android.kotlinweather.domain.dataSource.ForecastProvider
import com.bignerdranch.android.kotlinweather.domain.model.Forecast

/**
 * Created by Administrator on 2017/10/18/018.
 */
class RequestDayForecastCommand(val id: Long,
                                val forecastProvider: ForecastProvider = ForecastProvider())
    : Command<Forecast>{
    override fun execute() = forecastProvider.requestForecast(id)

}