package com.badmask_zly.kotlinlearndemofirst

import android.app.Application
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

/**
 * Created by badmask_zly on 2017/5/23.
 * Application 单例化最简单的方式
 */
class App : Application() {
    companion object {
//        像 Java 一样，创建一个单例
//        private var instance: Application? = null
//        fun instance() = instance!!

        //使用 notNull 委托，创建一个单例
//        var instance: App by Delegates.notNull()

        /**用上面的第二种方法会有一个问题，我们可以在 app 的任何地方去修改这个值，
         * 因为如果我们使用 Delegates.notNull() ，属性必须是 var 的。
         * 但是我们可以使用刚刚创建的委托，这样可以多一点保护
         */
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
//        instance = this

    }


}