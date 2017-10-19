package com.bignerdranch.android.kotlinweather.ui.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.appcompat.R.attr.color
import android.widget.TextView
import com.bignerdranch.android.kotlinweather.R
import com.bignerdranch.android.kotlinweather.domain.Command.RequestDayForecastCommand
import com.bignerdranch.android.kotlinweather.domain.model.Forecast
import com.bignerdranch.android.kotlinweather.extensions.color
import com.bignerdranch.android.kotlinweather.extensions.textColor
import com.bignerdranch.android.kotlinweather.extensions.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.async
import org.jetbrains.anko.ctx
import org.jetbrains.anko.uiThread
import java.text.DateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        toolbar.title = intent.getStringExtra(CITY_NAME)
        async {
            val result = RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute()
            uiThread { bindForecast(result) }
        }
    }
    
    private fun bindForecast(forecast: Forecast) = with(forecast) {
        Picasso.with(ctx).load(iconUrl).into(icon)
        supportActionBar?.subtitle = date.toDateString(DateFormat.FULL)
        weatherDescription.text = description
        bindWeather(high to maxTemperature, low to minTemperature)
    }

    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first}"
        it.second.textColor = color(when (it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 1..14 -> android.R.color.holo_orange_dark  //[]
            else -> android.R.color.holo_green_dark
        })
    }
}
