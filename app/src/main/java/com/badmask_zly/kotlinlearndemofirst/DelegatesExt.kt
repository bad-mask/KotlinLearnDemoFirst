package com.badmask_zly.kotlinlearndemofirst

import kotlin.properties.ReadWriteProperty

/**
 * Created by badmask_zly on 2017/5/23.
 */
object DelegatesExt {
    fun <T>notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}