package com.project.huray.projecthuray.dashboard.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

abstract class BaseViewHolder<in ITEM : Any?>(val parent: ViewGroup?, val view: View) :
    RecyclerView.ViewHolder(view){

//    fun onBindViewHolder(item: Any?) {
//        //need to try catch..
//        onViewCreated(item as? ITEM?)
//    }

    abstract fun onViewCreated(item: ITEM?)

}