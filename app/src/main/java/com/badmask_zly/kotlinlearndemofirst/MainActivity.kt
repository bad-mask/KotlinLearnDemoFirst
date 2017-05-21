package com.badmask_zly.kotlinlearndemofirst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 可以使用一个函数 listOf 创建一个常量的 List
 * 还有很多其他的函数可以选择，比如 setOf，arrayListOf，hashSetOf
 */
class MainActivity : AppCompatActivity() {

    private val items = listOf<String>(
            "zhangfjo fdjaof sj dsajfoaf",
            "zhangfjo fdjaof sj dsajfoaf",
            "zhangfjo fdjaof sj dsajfoaf",
            "zhangfjo fdjaof sj dsajfoaf",
            "zhangfjo fdjaof sj dsajfoaf");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        // message.text = "hello badmask-zly "

        setContentView(R.layout.activity_main_second)

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this);
        forecastList.adapter = ForecaseListAdapter2(items)

    }
}
