package com.badmask_zly.kotlinlearndemofirst.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by badmask_zly on 2017/5/21.
 *
 * 可以向访问属性一样访问 context 和 text
 */
class ForecaseListAdapter2(val items: List<String>) : RecyclerView.Adapter<ForecaseListAdapter2.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}