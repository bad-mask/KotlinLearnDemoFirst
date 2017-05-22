package com.badmask_zly.kotlinlearndemofirst.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.badmask_zly.kotlinlearndemofirst.domain.model

/**
 * Created by badmask_zly on 2017/5/22.
 */
class ForecastListAdapter(val weekForecast:model.ForecastList):RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int =weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        with(weekForecast.dailyForecast[position]){
            holder.textView.text="$date-$description-$high-/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView: TextView):RecyclerView.ViewHolder(textView)
}