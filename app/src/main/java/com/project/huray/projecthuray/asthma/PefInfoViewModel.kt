package com.project.huray.projecthuray.asthma

import android.databinding.Observable
import com.project.huray.projecthuray.data.realm.PefInfo
import com.project.huray.projecthuray.data.source.hub.HubDataRepository

class PefInfoViewModel(
    hubDataRepository: HubDataRepository
) : InfoViewModel(hubDataRepository) {

    lateinit var navigator: PefInfoNavigator

    override fun onTimePicker() {
        navigator.onTimePicker()
    }

    override fun onPefInfoSaved() {
        val pefInfoSaved: PefInfo = PefInfo().apply {
            date = repository.getDateKey()

            amTime = amTimeValue.get()
            amPefValue = this@PefInfoViewModel.amPefValue.get()

            pmTime = pmTimeValue.get()
            pmPefValue = this@PefInfoViewModel.pmPefValue.get()
        }
        repository.setAsthmaData(pefInfoSaved)
        navigator.onPefInfoSaved()
    }

}