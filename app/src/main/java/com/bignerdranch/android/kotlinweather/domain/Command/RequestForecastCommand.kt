package com.bignerdranch.android.kotlinweather.domain.Command

import com.bignerdranch.android.kotlinweather.data.server.ForecastDataMapper
import com.bignerdranch.android.kotlinweather.data.server.ForecastRequest
import com.bignerdranch.android.kotlinweather.domain.model.ForecastList

/**
 * Created by Administrator on 2017/10/7/007.
 */
//得到需要数据
class RequestForecastCommand(val zipCode: Long): Command<ForecastList> {
    override fun execute(): ForecastList
            = ForecastDataMapper().convertFromDataModel(zipCode, ForecastRequest(zipCode).execute())
}