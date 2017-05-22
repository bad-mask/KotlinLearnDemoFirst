package com.badmask_zly.kotlinlearndemofirst.domain

import com.badmask_zly.kotlinlearndemofirst.data.ReponseClasses

/**
 * Created by badmask_zly on 2017/5/22.
 */
class model {
    data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
        operator fun get(position: Int): Forecast = dailyForecast[position]
        fun size(): Int = dailyForecast.size
        //加上上面的两个方法后，可以稍微简化 ForecastListAdapter
    }

    data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)
}