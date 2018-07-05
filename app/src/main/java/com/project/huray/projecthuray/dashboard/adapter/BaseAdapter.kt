package com.project.huray.projecthuray.dashboard.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.project.huray.projecthuray.dashboard.adapter.holder.DashAsthmaHolder
import com.project.huray.projecthuray.dashboard.adapter.holder.DashAtopyHolder
import com.project.huray.projecthuray.dashboard.adapter.model.DashAdapterModel
import com.project.huray.projecthuray.data.realm.AtopyPhotos
import com.project.huray.projecthuray.data.realm.PefInfo

abstract class BaseAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    DashAdapterModel {

    private var hubItemList = mutableListOf<Any?>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DashAtopyHolder -> holder.onViewCreated(hubItemList[position] as AtopyPhotos)
            is DashAsthmaHolder -> holder.onViewCreated(hubItemList[position] as PefInfo)
        }
    }

    override fun addItem(item: Any?) {
        hubItemList.add(item)
    }

    override fun getItem(position: Int): Any? = hubItemList.get(position)

    override fun notifyDataSetChange() {
        notifyDataSetChanged()
    }

    override fun getItemCount() = hubItemList.size


    override fun getItemViewType(position: Int) = when (position) {
        0 -> DashBoardAdapter.TYPE_ATOPY
        else -> DashBoardAdapter.TYPE_ASTHMA
    }

    override fun setItem(items: List<Any?>) {
        val list = mutableListOf<Any?>()
        items.forEach {
            list.add(it)
        }
        hubItemList = list
    }
}