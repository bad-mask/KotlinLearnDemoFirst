package com.badmask_zly.kotlinlearndemofirst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.badmask_zly.kotlinlearndemofirst.adapter.ForecastListAdapter
import com.badmask_zly.kotlinlearndemofirst.domain.model
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class ForthActivity : AppCompatActivity() {
    val a = 5 as Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        /**
         *  a.inc() // a++
         *  a.dec() // a--
         *  a.unaryPlus()  // +a
         *  a.unaryMinus()  //-a
         */

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this);

        async() {
            val result = RequestForecastCommand("BeiJing").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result,
                        object : ForecastListAdapter.OnItemClickListener {
                            override fun invoke(forecast: model.Forecast) {
                                toast(forecast.date)
                            }
                        })
            }
        }

    }
}
