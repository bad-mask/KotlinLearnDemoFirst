package com.badmask_zly.kotlinlearndemofirst.model

import android.accounts.AuthenticatorDescription

/**
 * Created by badmask_zly on 2017/5/24.
 */
data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    val size: Int
        get() = dailyForecast.size
}

data class Forecast( val date: Long, val description: String,
                    val high: Int, val low: Int, val iconUrl: String)