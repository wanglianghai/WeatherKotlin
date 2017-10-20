package com.bignerdranch.android.kotlinweather.ui.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import com.bignerdranch.android.kotlinweather.R
import kotlinx.android.synthetic.main.toolbar.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        android.R.id.home -> {onBackPressed(); true}
        else -> false
    }
}
