package com.badmask_zly.kotlinlearndemofirst.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.badmask_zly.kotlinlearndemofirst.R
import com.badmask_zly.kotlinlearndemofirst.ctx
import com.badmask_zly.kotlinlearndemofirst.domain.model
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by badmask_zly on 2017/5/22.
 */
class ForecastListAdapter(val weekForecast: model.ForecastList, val itemClick: (model.Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    //这个 itemClick 函数接收一个 forecast 参数，然后不返回任何东西
    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
//        with(weekForecast[position]) {
//            // holder.textView.text = "$date-$description-$high/$low"
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(TextView(parent.context))
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    //class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    /**
     * 使用新的ViewHolder
     */
    class ViewHolder(view: View, val itemClick: (model.Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: model.Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }

    }


    /**
     * listener 可以被以下两种方式调用：
     * itemClick.invoke(forecast)
     * itemClick(forecast)
     */
    //    public interface OnItemClickListener {
//        operator fun invoke(forecast: model.Forecast)
//    }
}