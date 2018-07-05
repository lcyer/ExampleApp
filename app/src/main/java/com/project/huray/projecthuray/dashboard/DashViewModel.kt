package com.project.huray.projecthuray.dashboard

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableField
import android.support.annotation.StringRes
import android.util.Log
import android.view.View
import com.project.huray.projecthuray.R
import com.project.huray.projecthuray.dashboard.adapter.model.DashAdapterModel
import com.project.huray.projecthuray.data.realm.AtopyPhotos
import com.project.huray.projecthuray.data.realm.PefInfo
import com.project.huray.projecthuray.data.source.hub.HubDataRepository
import com.project.huray.projecthuray.util.*

class DashViewModel(
    private val repository: HubDataRepository
) : BaseObservable() {

    val monthObservable: ObservableField<String> = ObservableField()
    val monday: ObservableField<String> = ObservableField()
    val tuesday: ObservableField<String> = ObservableField()
    val wednesday: ObservableField<String> = ObservableField()
    val thursday: ObservableField<String> = ObservableField()
    val friday: ObservableField<String> = ObservableField()
    val saturday: ObservableField<String> = ObservableField()
    val sunday: ObservableField<String> = ObservableField()

    lateinit var dashAdapterModel: DashAdapterModel
    lateinit var navigator: HubNavigator

    fun onLoadDashItem() {
        val items = mutableListOf<Any?>()

        val atopyItem = repository.getAtopyData(repository.getDateKey())
        atopyItem?.let {
            items.add(it)
        } ?: let {
            items.add(AtopyPhotos())
        }

        val pefInfoItem = repository.getAsthmaData(repository.getDateKey())
        pefInfoItem?.let {
            items.add(it)
        } ?: let {
            items.add(PefInfo())
        }

        dashAdapterModel.setItem(items)
        dashAdapterModel.notifyDataSetChange()
    }

    fun initCalendar() {
        //defalutkey -> nowDate
        repository.setDateKey("${getToday()}")

        monthObservable.set(getCurMonth() + "월")
        monday.set(getWeekDay(R.string.monday).fixDatetoDay())
        tuesday.set(getWeekDay(R.string.tuesday).fixDatetoDay())
        wednesday.set(getWeekDay(R.string.wednesday).fixDatetoDay())
        thursday.set(getWeekDay(R.string.thursday).fixDatetoDay())
        friday.set(getWeekDay(R.string.friday).fixDatetoDay())
        saturday.set(getWeekDay(R.string.saturday).fixDatetoDay())
        sunday.set(getWeekDay(R.string.sunday).fixDatetoDay())

        selectedNowDate()
    }

    @Bindable
    fun getMonth(): String? {
        return monthObservable.get()
    }

    fun selectedNowDate() {
        monday.get().takeIf {
            it == getCurDay()
        }?.apply {
            navigator.showNowDate(R.string.monday)
        }
        tuesday.get().takeIf {
            it == getCurDay()
        }?.apply {
            navigator.showNowDate(R.string.tuesday)
        }
        wednesday.get().takeIf {
            it == getCurDay()
        }?.apply {
            navigator.showNowDate(R.string.wednesday)
        }
        thursday.get().takeIf {
            it == getCurDay()
        }?.apply {
            navigator.showNowDate(R.string.thursday)
        }
        friday.get().takeIf {
            it == getCurDay()
        }?.apply {
            navigator.showNowDate(R.string.friday)
        }
        saturday.get().takeIf {
            it == getCurDay()
        }?.apply {
            navigator.showNowDate(R.string.saturday)
        }
        sunday.get().takeIf {
            it == getCurDay()
        }?.apply {
            navigator.showNowDate(R.string.sunday)
        }
    }

    fun makeDateKey(@StringRes type: Int) {
        repository.setDateKey(getWeekDay(type).fixDate())
    }

    fun onClickDay(view: View) {
        navigator.onClickDayWithLoadContents(view)
    }

}
