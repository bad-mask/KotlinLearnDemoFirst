package com.badmask_zly.kotlinlearndemofirst.extensions


/**
 * Created by badmask_zly on 2017/5/24.
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): kotlin.Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()