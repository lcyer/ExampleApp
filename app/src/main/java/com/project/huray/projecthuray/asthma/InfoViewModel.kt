package com.project.huray.projecthuray.asthma

import android.databinding.BaseObservable
import android.databinding.Observable
import android.databinding.ObservableField
import com.project.huray.projecthuray.asthma.timepicker.TimePickerFragment
import com.project.huray.projecthuray.data.realm.PefInfo
import com.project.huray.projecthuray.data.source.hub.HubDataRepository
import com.project.huray.projecthuray.util.fixDatetoKor

abstract class InfoViewModel(
    val repository: HubDataRepository
) : BaseObservable() {

    val dateTitle: ObservableField<String> = ObservableField()

    val pefInfoObservable: ObservableField<PefInfo> = ObservableField()

    val amTimeValue: ObservableField<String> = ObservableField()
    val amPefValue: ObservableField<String> = ObservableField()

    val pmTimeValue: ObservableField<String> = ObservableField()
    val pmPefValue: ObservableField<String> = ObservableField()

    init {
        pefInfoObservable.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                pefInfoObservable.get()?.let {
                    it.takeIf { it.amTime != null }.apply {
                        amTimeValue.set(it.amTime)
                        amPefValue.set(it.amPefValue)
                    }
                    it.takeIf { it.pmTime != null }.apply {
                        pmTimeValue.set(it.pmTime)
                        pmPefValue.set(it.pmPefValue)
                    }
                }
            }
        })
    }

    fun onLoadPefInfo() {
        dateTitle.set(repository.getDateKey().fixDatetoKor())
        val pefInfo = repository.getAsthmaData(repository.getDateKey())
        pefInfo?.let {
            pefInfoObservable.set(pefInfo)
        }
    }

    fun setTimePicker(hour: Int, min: Int) {
        if (hour < 12) amTimeValue.set("${hour}:${min}") else pmTimeValue.set("${hour}:${min}")
    }

    abstract fun onPefInfoSaved()
    abstract fun onTimePicker()

}