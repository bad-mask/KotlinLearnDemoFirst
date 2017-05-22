package com.badmask_zly.kotlinlearndemofirst.domain

/**
 * Created by badmask_zly on 2017/5/22.
 * 一切 kotlin 函数都会返回一个值。如果没有指定，它就默认返回一个 Unit 类
 */
public interface Command<T> {
    fun execute(): T
}