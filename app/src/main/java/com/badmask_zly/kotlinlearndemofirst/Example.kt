package com.badmask_zly.kotlinlearndemofirst

import kotlin.properties.Delegates

/**
 * Created by badmask_zly on 2017/5/23.
 * 这个类无实际意义，只是
 */
class Example {
    val p: String by Delegates.notNull<String>()
    //它使用了 by 这个关键字来指定一个委托对象


    val positiveNumber = Delegates.vetoable(0) {
        d, old, new ->
        new >= 0
    }
    //上面这个委托只允许在新的值是正数的时候执行保存
}