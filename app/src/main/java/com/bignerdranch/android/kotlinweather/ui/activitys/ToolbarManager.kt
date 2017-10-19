package com.bignerdranch.android.kotlinweather.ui.activitys

import android.support.v7.widget.Toolbar

/**
 * 改变title
指定是否显示上一步的导航动作
滚动时的toolbar动画
给所有的activity设置相同的菜单，甚至行为

 */
interface ToolbarManager {
    val toolbar: Toolbar        //子类会实现这个接口并重写这个属性

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    //来初始化toolbar
    fun initToolbar() {

    }
}