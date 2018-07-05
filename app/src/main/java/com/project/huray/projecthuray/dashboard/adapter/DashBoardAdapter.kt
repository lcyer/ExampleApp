package com.project.huray.projecthuray.dashboard.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.huray.projecthuray.dashboard.HubNavigator
import com.project.huray.projecthuray.R
import com.project.huray.projecthuray.dashboard.DashItemViewModel
import com.project.huray.projecthuray.dashboard.adapter.holder.DashAsthmaHolder
import com.project.huray.projecthuray.dashboard.adapter.holder.DashAtopyHolder
import com.project.huray.projecthuray.data.source.hub.HubDataRepository
import com.project.huray.projecthuray.databinding.AsthmaInfoItemBinding
import com.project.huray.projecthuray.databinding.AtopyPhotoItemBinding

class DashBoardAdapter(
    context: Context?,
    private val hubNavigator: HubNavigator
) : BaseAdapter(context) {

    val dashItemViewModel: DashItemViewModel by lazy {
        DashItemViewModel(HubDataRepository)
    }

    companion object {
        val TYPE_ATOPY = 0
        val TYPE_ASTHMA = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        dashItemViewModel.navigator = hubNavigator

        return when (viewType) {
            TYPE_ATOPY -> {
                //AtopyPhotoItemBinding
                val view =
                    LayoutInflater.from(context).inflate(R.layout.atopy_photo_item, parent, false)
                val atopyPhotoItemBinding = AtopyPhotoItemBinding.bind(view)
                atopyPhotoItemBinding.viewmodel = dashItemViewModel

                DashAtopyHolder(parent, atopyPhotoItemBinding.root, dashItemViewModel)
            }
            else -> {
                //AsthmaInfoItemBinding
                val view =
                    LayoutInflater.from(context).inflate(R.layout.asthma_info_item, parent, false)
                val asthmaInfoItemBinding = AsthmaInfoItemBinding.bind(view)
                asthmaInfoItemBinding.viewmodel = dashItemViewModel

                DashAsthmaHolder(parent, asthmaInfoItemBinding.root, dashItemViewModel)
            }
        }
    }

}
