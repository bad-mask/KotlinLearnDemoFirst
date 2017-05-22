package com.badmask_zly.kotlinlearndemofirst.domain

import com.badmask_zly.kotlinlearndemofirst.data.ReponseClasses
import java.text.DateFormat
import java.util.*

import com.badmask_zly.kotlinlearndemofirst.domain.model.Forecast as ModelForecast
//当我们使用了两个相同名字的类，我们可以给其中一个指定一个别名，这样我们就不需要写完整的包名了


/**
 * Created by badmask_zly on 2017/5/22.
 */
public class ForecastDataMapper {

    fun convertFromDataModel(forecast: ReponseClasses.ForecastResult): model.ForecastList {
        return model.ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list:List<ReponseClasses.Forecast>):List<ModelForecast>{
        return list.map { convertForecastItemToDomain(it) }//这一条语句可以注意一下  ，函数操作符，
    }

    private fun convertForecastItemToDomain(forecast: ReponseClasses.Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }


}