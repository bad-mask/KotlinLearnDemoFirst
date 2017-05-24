package com.badmask_zly.kotlinlearndemofirst.db

import android.database.sqlite.SQLiteDatabase
import com.badmask_zly.kotlinlearndemofirst.beans.CityForecastTable
import com.badmask_zly.kotlinlearndemofirst.beans.DayForecastTable
import com.badmask_zly.kotlinlearndemofirst.extensions.parseList
import com.badmask_zly.kotlinlearndemofirst.extensions.parseOpt
import com.badmask_zly.kotlinlearndemofirst.extensions.toVarargArray
import com.badmask_zly.kotlinlearndemofirst.model.ForecastList
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import java.util.*

/**
 * Created by badmask_zly on 2017/5/23.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dateMapper: DbDataMapper = DbDataMapper()) {
    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID}=?" + "AND ${DayForecastTable.DATE}>=?"

        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME).whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dateMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dateMapper.convertFromDomain(forecast)){

            insert(CityForecastTable.NAME,*map.toVarargArray())
            //在 toVarargArray 函数结果前面使用 * 表示这个 array 会被分解成为一个 vararg 参数。这个在 Java 中是自动处理的，但是我们需要在 Kotlin 中明确指出

            dailyForecast.forEach { insert(DayForecastTable.NAME,*it.map.toVarargArray()) }
        }
    }

    /**
     * 清空表中的数据。Anko 没有提供比较漂亮的方式来做这个
     * 所以，我们创建了一个 SQLiteDatabase 的扩展函数来让我们可以像 SQL 查询一样来执行它
     */
    fun SQLiteDatabase.clear(tableName: String) {
        execSQL("delete form $tableName")
    }
}
