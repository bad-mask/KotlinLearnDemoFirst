package com.badmask_zly.kotlinlearndemofirst.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by badmask_zly on 2017/5/22.
 */
public class ForecastRequest(val zipCode: String) {
    companion object {
        /**
         * 把静态的 url 放在一个 companion object（伴随对象） 中。
         * 如果我们之后还要对该 API 增加更过请求，我们需要提取它。
         *
         *
         */
        private val APP_ID = "a6584c8f1f35a3c0fdcd334784feea2c"
        //这个 APP_ID 一定要去 https://openweathermap.org 网站自行注册
        private val URL1 = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL1}&APPID=${APP_ID}&q="
    }

    fun execute(): ReponseClasses.ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL+zipCode).readText()
        Log.e("zly","COMPLETE_URL+zipCode   ==   "+COMPLETE_URL+zipCode)
        Log.e("zly","forecastJsonStr  ==   "+forecastJsonStr)
        return Gson().fromJson(forecastJsonStr,ReponseClasses.ForecastResult::class.java)
    }
}