package com.badmask_zly.kotlinlearndemofirst

import com.badmask_zly.kotlinlearndemofirst.data.ForecastRequest
import com.badmask_zly.kotlinlearndemofirst.domain.Command
import com.badmask_zly.kotlinlearndemofirst.domain.ForecastDataMapper
import com.badmask_zly.kotlinlearndemofirst.domain.model

/**
 * Created by badmask_zly on 2017/5/22.
 */
class RequestForecastCommand(val zipCode: String) : Command<model.ForecastList> {
    override fun execute(): model.ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}