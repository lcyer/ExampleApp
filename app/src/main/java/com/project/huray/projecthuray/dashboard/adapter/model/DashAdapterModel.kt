package com.project.huray.projecthuray.dashboard.adapter.model

interface DashAdapterModel {
    fun addItem(item: Any?)
    fun setItem(items : List<Any?>)
    fun getItem(position: Int): Any?
    fun getItemCount(): Int
    fun notifyDataSetChange()
}