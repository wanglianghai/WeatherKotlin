package com.bignerdranch.android.kotlinweather.ui

import android.app.Application
import com.bignerdranch.android.kotlinweather.extensions.DelegatesExt

/**
 * Created by Administrator on 2017/10/12/012.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}