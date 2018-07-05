package com.project.huray.projecthuray.dashboard.adapter.holder

import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.project.huray.projecthuray.dashboard.DashItemViewModel
import com.project.huray.projecthuray.data.realm.AtopyPhotos


class DashAtopyHolder(parent: ViewGroup, view: View, val viewModel: DashItemViewModel) : BaseViewHolder<AtopyPhotos>(parent, view) {

    override fun onViewCreated(item: AtopyPhotos?) {
        item?.let {
            Log.d("cylee","adapter item - $item")
        viewModel.setHubObservle(it)
        }
    }

}