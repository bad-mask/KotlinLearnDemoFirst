package com.badmask_zly.kotlinlearndemofirst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.badmask_zly.kotlinlearndemofirst.adapter.ForecastListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this);

        async(){
           val result = RequestForecastCommand("BeiJing").execute()
            uiThread { forecastList.adapter=ForecastListAdapter(result) }
        }
    }
}
