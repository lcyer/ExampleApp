package com.project.huray.projecthuray.dashboard

import com.project.huray.projecthuray.data.source.hub.HubDataRepository

class DashItemViewModel(
    hubDataRepository: HubDataRepository
) : ItemVieModel(hubDataRepository) {

    lateinit var navigator: HubNavigator

    override fun addPefInfo() {
        navigator.addPefInfo()
    }

    override fun addAtopyPhoto() {
        navigator.addAtopyPhoto()
    }

}