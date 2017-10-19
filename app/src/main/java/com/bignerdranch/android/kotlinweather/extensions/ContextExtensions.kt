package com.bignerdranch.android.kotlinweather.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by Administrator on 2017/10/18/018.
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)