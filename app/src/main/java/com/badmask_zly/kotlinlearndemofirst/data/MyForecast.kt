package com.badmask_zly.kotlinlearndemofirst.data

import java.util.*

/**
 * Created by badmask_zly on 2017/5/22.
 * learn 数据类
 * 数据类，通常只提供了用于访问它们属性的简单的 getter 和 setter
 * @description :此类在本工程中无实际意义
 */
data class MyForecast(val date: Date, val temperature: Float, val details: String)