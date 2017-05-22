package com.badmask_zly.kotlinlearndemofirst

import android.util.Log
import java.net.URL

/**
 * Created by badmask_zly on 2017/5/22.
 */
class Request(val url:String) {
    public fun run(){
        val forecastjsonStr =URL(url).readText()
        //readText ，这是 Kotlin 标准库中的扩展函数
        Log.e("zly","javaClass.simpleName  : "+javaClass.simpleName+";  forecastjsonStr :  "+forecastjsonStr)
    }
}