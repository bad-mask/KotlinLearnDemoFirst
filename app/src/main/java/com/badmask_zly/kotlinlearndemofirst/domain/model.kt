package com.badmask_zly.kotlinlearndemofirst.domain

import com.badmask_zly.kotlinlearndemofirst.data.ReponseClasses
import java.text.FieldPosition

/**
 * Created by badmask_zly on 2017/5/22.
 */
class model {
    data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
        //operator fun get(position: Int): Forecast = dailyForecast[position]
        //fun size(): Int = dailyForecast.size
        //加上上面的两个方法后，可以稍微简化 ForecastListAdapter
        //上面的两个方法都指定了返回值的类型，但是在 Kotlin 中，我们不需要去指定一个函数的返回值类型，它可以让编译器推断出来
        operator fun get(position: Int) = dailyForecast[position]

        fun size() = dailyForecast.size
    }

    data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)
}