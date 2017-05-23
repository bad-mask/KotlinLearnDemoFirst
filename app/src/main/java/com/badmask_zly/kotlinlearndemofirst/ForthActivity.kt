package com.badmask_zly.kotlinlearndemofirst

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.badmask_zly.kotlinlearndemofirst.adapter.ForecastListAdapter
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class ForthActivity : AppCompatActivity() {
    // val a = 5 as Int

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
                // forecastList.adapter = ForecastListAdapter(result ){forecast -> toast(forecast.date) }

                /**
                 * 上面的代码还可以简化
                 * 如果这个函数只接收一个参数，那我们可以使用 it 引用，而不用去指定左边的参数
                 */
                val adapter = ForecastListAdapter(result) { toast(it.date) }
                forecastList.adapter = adapter
            }
        }

        //supportsLollipop { window.setst }//总是执行错误
      // TODO("不知道怎么写  涉及到内联函数的使用")

    }

    inline fun supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }
}
