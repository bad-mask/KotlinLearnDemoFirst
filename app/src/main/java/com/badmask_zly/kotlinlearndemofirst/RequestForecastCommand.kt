package com.badmask_zly.kotlinlearndemofirst

import com.badmask_zly.kotlinlearndemofirst.data.ForecastRequest
import com.badmask_zly.kotlinlearndemofirst.domain.Command
import com.badmask_zly.kotlinlearndemofirst.domain.ForecastDataMapper
import com.badmask_zly.kotlinlearndemofirst.domain.model

/**
 * Created by badmask_zly on 2017/5/22.
 */
class RequestForecastCommand(private val zipCode: String) : Command<model.ForecastList> {
    /**
     * 所作的事情就是我们创建了一个不可修改的属性 zipCode ，它的值我们只能去得到，不能去修改它。
     * 所以这个不大的改动让代码看起来更加清晰。
     * 如果我们在编写类的时候，你觉得某些属性因为是什么原因不能对别人可见，那就把它定义为 private
     */
    override fun execute(): model.ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}