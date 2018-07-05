package com.project.huray.projecthuray.dashboard.adapter.holder

import android.view.View
import android.view.ViewGroup
import com.project.huray.projecthuray.dashboard.DashItemViewModel
import com.project.huray.projecthuray.data.realm.PefInfo

class DashAsthmaHolder(parent: ViewGroup, view: View, val viewModel: DashItemViewModel): BaseViewHolder<PefInfo>(parent, view) {

    override fun onViewCreated(item: PefInfo?) {
        item?.let {
            viewModel.setHubObservle(it)
        }
    }

}