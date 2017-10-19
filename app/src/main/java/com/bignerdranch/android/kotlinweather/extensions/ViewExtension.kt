package com.bignerdranch.android.kotlinweather.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by Administrator on 2017/10/11/011.
 */
// Anko 提供了大量的扩展函数
val View.ctx: Context   //扩展属性
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)
