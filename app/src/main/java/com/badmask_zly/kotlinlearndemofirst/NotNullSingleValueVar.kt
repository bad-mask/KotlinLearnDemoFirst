package com.badmask_zly.kotlinlearndemofirst

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by badmask_zly on 2017/5/23.
 * 创建一个 notNull 的委托，它只能被赋值一次，如果第二次赋值，它就会抛出异常
 * 这个委托可以作用在任何非null的类型，它接收任何类型的引用，然后像 getter 和 setter 那样使用 T
 *
 * 现在去实现函数：
 * getter 函数，如果已经被初始化，则会返回一个值，否则会抛异常
 * setter 函数，如果仍然是 null ，则赋值，否则会抛异常
 */
public class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?:
                throw IllegalStateException("" + "not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("already initialized")
    }


}