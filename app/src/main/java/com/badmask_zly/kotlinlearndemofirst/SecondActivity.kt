package com.badmask_zly.kotlinlearndemofirst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.badmask_zly.kotlinlearndemofirst.datebase.ForecastDbHelper
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import kotlin.properties.ReadWriteProperty


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        async() {
//            Request("http://www.baidu.com").run()
//            uiThread { longToast("Request performed") }
//            /**UIThread 有一个很不错的一点就是可以以来调用者。如果它是被一个 Activity 调用的，
//             * 那么如果 activity.isFinishing() 返回 true，则 uiThread 不会执行，这样就不会在
//             * Activity 销毁的时候遇到崩溃的情况了
//             */
//        }

        //下面只是展示对于这个类怎么去创建一个必须要的 map
//        val conf = Configuration(mapOf(
//                "width" to 1080,
//                "height" to 720,
//                "dp" to 240,
//                "deviceName" to "mydevice"
//        ))

//        当 ForecastDbHelper 注入依赖后，我们就有两种方式来创建这个类
//        val dbHelper1 = ForecastDbHelper()
//        val dbHelper2 = ForecastDbHelper(this)


    }
}
