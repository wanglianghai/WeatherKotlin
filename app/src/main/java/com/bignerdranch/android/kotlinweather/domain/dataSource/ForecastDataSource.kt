package com.bignerdranch.android.kotlinweather.domain.dataSource

import com.bignerdranch.android.kotlinweather.domain.model.ForecastList

/**
 * Created by Administrator on 2017/10/17/017.
 */
//给接口定义一些我们实现 provider 需要使用到的数据源
//provider 需要一个接收 zip code 和一个 date ，然后它应该根据那一天返回
//一周的天气预报。
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}