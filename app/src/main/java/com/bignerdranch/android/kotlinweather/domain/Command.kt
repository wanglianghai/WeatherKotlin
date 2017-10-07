package com.bignerdranch.android.kotlinweather.domain

/**
 * Created by Administrator on 2017/10/7/007.
 */
interface Command<T> {
    fun execute(): T
}