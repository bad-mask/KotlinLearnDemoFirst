package com.badmask_zly.kotlinlearndemofirst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fifth.*
import org.jetbrains.anko.toast

/**
 * 主要是学习 Lambdas 表达式
 */

class FifthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        tv_fifth.setOnClickListener ({ view -> toast("Click")  })

        //如果左边的参数没有使用到，可以省略左边的参数
        tv_fifth.setOnClickListener ({ toast("Click") })

        //如果这个函数的最后一个参数是一个函数，我们可以把这个函数移动到圆括号外面
        tv_fifth.setOnClickListener(){ toast("Click") }

        //如果这个函数只有一个参数，我们可以省略这个圆括号
        tv_fifth.setOnClickListener { toast("Click") }

    }
}
