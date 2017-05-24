package com.badmask_zly.kotlinlearndemofirst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


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


        //exerciseForFun()
        //exercise_YSCZF()
        //exercise_YS()
        // exercise_SCCZF()
        exercise_SXCZF()
    }

    /**
     * 顺序操作符的练习
     */
    fun exercise_SXCZF() {
        val list = listOf(4, 5, 6, 1, 2, 3)
        // list.reversed().forEach { Log.e("zly", "reversed == " + it) }
        // list.sorted().forEach { Log.e("zly", "sorted == " + it) }
        //list.sortedBy { it % 7 }.forEach { Log.e("zly", "sortedBy == " + it) }
        //list.sortedDescending().forEach { Log.e("zly", "sortedDescending == " + it) }
        list.sortedByDescending { it % 8 }.forEach { Log.e("zly", "sortedByDescending == " + it) }

    }

    /**
     * 生产操作符的练习
     */
    fun exercise_SCCZF() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        //文档和网上一些老的资料还提到了merge操作，编码时提示找不到符号，查资料发现从Kotlin 1.0 Beta 2后的版本开始就弃用了。
//        list.partition { it % 2 == 0 }.first.forEach { Log.e("zly","first == "+it) }
//        list.partition { it % 2 == 0 }.second.forEach { Log.e("zly","second == "+it) }

        // (list.partition { it % 2 == 0 }.first +  list.partition { it % 2 == 0 }.second).forEach { Log.e("zly","plus   ==   "+it)  }

        //list.partition { it % 2 == 0 }.first.zip(list.partition { it % 2 == 0 }.second).forEach { Log.e("zly","  zip   ==   "+it)  }
        //输出结果是 (2,1)  (4,3)   (6,5)

        list.partition { it % 2 == 0 }.first.zip(list.partition { it % 2 == 0 }.second).unzip().first.forEach { Log.e("zly", " first unzip   ==   " + it) }
        list.partition { it % 2 == 0 }.first.zip(list.partition { it % 2 == 0 }.second).unzip().second.forEach { Log.e("zly", " second unzip   ==   " + it) }

    }


    /**
     * 元素操作符的练习
     */
    fun exercise_YS() {
        val list = listOf(1, 2, 3, 4, 5, 6, 4)
        Log.e("zly", "list.contains(2)   =   " + list.contains(2))
        Log.e("zly", "list.elementAt(0)   =   " + list.elementAt(0))
        Log.e("zly", "list.elementAtOrElse(20, { 2 * it })   =   " + list.elementAtOrElse(20, { 2 * it }))
        Log.e("zly", "list.elementAtOrNull(20)   =   " + list.elementAtOrNull(20))
        Log.e("zly", "list.first { it % 2 == 0 }   =   " + list.first { it % 2 == 0 })
        Log.e("zly", "list.first { it % 1 == 0 }   =   " + list.first { it % 1 == 0 })

        Log.e("zly", "list.firstOrNull { it % 7 == 0 }   =   " + list.firstOrNull { it % 7 == 0 })
        Log.e("zly", "list.indexOf {1}  =   " + list.indexOf(1))
        Log.e("zly", "list.indexOfFirst { it % 4 == 0 } =   " + list.indexOfFirst { it % 4 == 0 })
        Log.e("zly", "list.indexOfLast { it % 4 == 0 } =   " + list.indexOfLast { it % 4 == 0 })
        Log.e("zly", "list.last { it % 2 == 0 }    =   " + list.last { it % 2 == 0 })
        Log.e("zly", "list.lastIndexOf(3)    =   " + list.lastIndexOf(3))
        Log.e("zly", "list.lastOrNull { it % 9 == 0}     =   " + list.lastOrNull { it % 9 == 0 })
        Log.e("zly", "list.single { it % 4 == 0 }     =   " + list.single { it % 5 == 0 })
        Log.e("zly", "list.single { it % 9 == 0 }     =   " + list.singleOrNull() { it % 9 == 0 })
    }


    /**
     * 映射操作符的练习
     */
    fun exercise_YSCZF() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        list.flatMap { listOf(it, it + 1) }.forEach { Log.e("zly", "it =====  " + it) }


        Log.e("zly", "list.groupBy { if (it % 2 == 0) even else odd }.get(even)   =    "
                + list.groupBy { if (it % 2 == 0) "even" else "odd" }.get("odd"))

        list.map { it * 2 }.forEach { Log.e("zly", "   it    =     " + it) }
        list.mapIndexed { index, i -> i * index }.forEach { Log.e("zly", "it ==    " + it) }

        list.mapNotNull { it * 2 }.forEach { Log.e("zly", "it  ==   " + it) }

    }

    fun exerciseForFun() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        //下面是 总数操作符
        Log.e("zly", "list.any { it%2==0 }      =     " + list.any { it % 2 == 0 })
        Log.e("zly", "list.all { it < 10 }      =     " + list.all { it < 10 })
        Log.e("zly", "list.count {it%2==0  }      =     " + list.count { it % 2 == 0 })
        Log.e("zly", "list.fold(4){total,next->total+next}      =     " + list.fold(4) { total, next -> total + next })
        Log.e("zly", "list.foldRight(4){total,next->total+next}      =     " + list.foldRight(4) { total, next -> total + next })
        Log.e("zly", "list.max()      =     " + list.max())
        Log.e("zly", "list.maxBy { -it }      =     " + list.maxBy { -it })
        Log.e("zly", "list.min()      =     " + list.min())
        Log.e("zly", "list.minBy { -it }     =     " + list.minBy { -it })
        Log.e("zly", "list.none { it % 7 == 0 }     =     " + list.none { it % 7 == 0 })
        Log.e("zly", "list.reduce { total, next -> total + next }    =     " + list.reduce { total, next -> total + next })
        Log.e("zly", "list.reduceRight { total, next -> total + next }    =     " + list.reduceRight { total, next -> total + next })
        Log.e("zly", "list.sumBy { it % 2 }    =     " + list.sumBy { it % 2 })
        list.forEach { Log.e("zly", "list.forEach { it }      =     " + it) }
        list.forEachIndexed { index, i -> Log.e("zly", "list.forEachIndexed     index = " + index + "    ;  i  =  " + i) }
        Log.e("zly", "================================================")

        //下面是过滤操作符

        Log.e("zly", "list.drop(2)      =     " + list.drop(2))
        Log.e("zly", "list.dropWhile { it < 4 }      =     " + list.dropWhile { it < 4 })
        Log.e("zly", "list.dropLastWhile { it > 5 }     =     " + list.dropLastWhile { it > 5 })
        Log.e("zly", "list.filter { it % 2 == 0 }     =     " + list.filter { it % 2 == 0 })
        Log.e("zly", "list.filterNot { it % 2 == 0 }     =     " + list.filterNot { it % 2 == 0 })
        Log.e("zly", "list.filterNotNull()     =     " + list.filterNotNull())
        Log.e("zly", "list.slice(listOf(1,3,4))     =     " + list.slice(listOf(1, 3, 4)))
        Log.e("zly", "list.take(2)     =     " + list.take(2))
        Log.e("zly", "list.takeLast(2)     =     " + list.takeLast(2))
        Log.e("zly", "list.takeWhile { it < 3 }     =     " + list.takeWhile { it < 3 })
        Log.e("zly", "list.takeLastWhile { it > 3 }     =     " + list.takeLastWhile { it < 7 })


    }
}
