package com.badmask_zly.kotlinlearndemofirst

/**
 * Created by badmask_zly on 2017/5/23.
 *
 * exercise 从 map 中映射值
 */
class Configuration(map: Map<String, Any?>) {
    val width: Int by map
    val height: Int by map
    val dp: Int by map
    val deviceName: String by map
}