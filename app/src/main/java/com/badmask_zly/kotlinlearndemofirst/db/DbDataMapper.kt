package com.badmask_zly.kotlinlearndemofirst.db

import com.badmask_zly.kotlinlearndemofirst.model.Forecast
import com.badmask_zly.kotlinlearndemofirst.model.ForecastList

/**
 * Created by badmask_zly on 2017/5/24.
 */
class DbDataMapper {

    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast( date, description, high, low, iconUrl)
    }
}