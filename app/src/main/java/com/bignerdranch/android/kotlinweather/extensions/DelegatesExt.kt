package com.bignerdranch.android.kotlinweather.extensions

import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/10/12/012.
 */
object DelegatesExt{
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T> {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>) : T =    //默认的上界（如果没有声明）是 Any?
            value ?: throw IllegalStateException("${property.name} not initialized")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else  throw IllegalStateException("${property.name} already initialized")
    }
}

