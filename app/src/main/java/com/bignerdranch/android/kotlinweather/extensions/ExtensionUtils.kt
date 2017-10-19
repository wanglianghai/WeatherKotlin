package com.bignerdranch.android.kotlinweather.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by Administrator on 2017/10/18/018.
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}