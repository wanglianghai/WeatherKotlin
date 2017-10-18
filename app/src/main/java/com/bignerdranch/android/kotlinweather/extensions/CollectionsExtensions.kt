package com.bignerdranch.android.kotlinweather.extensions

/**
 * Created by Administrator on 2017/10/16/016.
 */
fun <K, V : Any> Map<K, V?>.toVararArray() : Array<out Pair<K, V>> =
        map ({Pair(it.key, it.value!!)}).toTypedArray()  //V? 值允许为空

inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?) : R{
    for(element in this) {
        val result = predicate(element)
        if (result != null) return result
    }

    throw NoSuchElementException("No element matching predicate was found.")
}