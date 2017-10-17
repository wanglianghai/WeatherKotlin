package com.bignerdranch.android.kotlinweather.extensions

/**
 * Created by Administrator on 2017/10/16/016.
 */
fun <K, V : Any> Map<K, V?>.toVararArray() : Array<out Pair<K, V>> =
        map ({Pair(it.key, it.value!!)}).toTypedArray()  //V? 值允许为空