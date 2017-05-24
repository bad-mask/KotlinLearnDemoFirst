package com.badmask_zly.kotlinlearndemofirst.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.badmask_zly.kotlinlearndemofirst.App
import com.badmask_zly.kotlinlearndemofirst.beans.CityForecastTable
import com.badmask_zly.kotlinlearndemofirst.beans.DayForecastTable
import org.jetbrains.anko.db.*

/**
 * Created by badmask_zly on 2017/5/23.
 */
class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {
    //class ForecastDbHelper() : ManagedSQLiteOpenHelper(App.instance, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {
  //依赖注入：如改成上面的写法，给构造函数的参数通过分配默认值的方式提供一个依赖，然后在不同的情况下提供不同的实例
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)
        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
        //instance 属性使用了 lazy 委托，它表示直到它真的被调用才会被创建。  lazy 委托是线程安全的
    }

    public fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
}