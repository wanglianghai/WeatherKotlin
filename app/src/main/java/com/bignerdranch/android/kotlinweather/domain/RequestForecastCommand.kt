package com.bignerdranch.android.kotlinweather.domain

import com.bignerdranch.android.kotlinweather.net.ForecastRequest

/**
 * Created by Administrator on 2017/10/7/007.
 */
class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList
            = ForecastDataMapper().convertFromDataModel(ForecastRequest(zipCode).execute())
}