package com.project.huray.projecthuray.dashboard

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.ObservableField
import android.net.Uri
import android.util.Log
import com.android.databinding.library.baseAdapters.BR
import com.project.huray.projecthuray.data.realm.AtopyPhotos
import com.project.huray.projecthuray.data.realm.PefInfo
import com.project.huray.projecthuray.data.source.hub.HubDataRepository

abstract class ItemVieModel(val hubDataRepository: HubDataRepository) : BaseObservable() {

    //atopy item observle
    val atopyObservle: ObservableField<AtopyPhotos> = ObservableField()
    val atopyPhotoFirst: ObservableField<String> = ObservableField()
    val atopyPhotoSecond: ObservableField<String> = ObservableField()
    val atopyPhotoThird: ObservableField<String> = ObservableField()

    //asthma item observle
    val pefInfoObservle: ObservableField<PefInfo> = ObservableField()
    val amTime: ObservableField<String> = ObservableField()
    val amPefValue: ObservableField<String> = ObservableField()

    val pmTime: ObservableField<String> = ObservableField()
    val pmPefValue: ObservableField<String> = ObservableField()

    init {
        //atopy
        atopyObservle.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                atopyObservle.get()?.let {
                    atopyPhotoFirst.set(it.photoFirst)
                    atopyPhotoSecond.set(it.photoSecond)
                    atopyPhotoThird.set(it.photoThird)
                    notifyPropertyChanged(BR.empty)
                }
            }
        })
        //asthma
        pefInfoObservle.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                pefInfoObservle.get()?.let {
                    it.let {
                        it.takeIf { it.amTime != null }.apply {
                            amTime.set(it.amTime)
                            amPefValue.set(it.amPefValue)
                        }

                        it.takeIf { it.pmTime != null }.apply {
                            pmTime.set(it.pmTime)
                            pmPefValue.set(it.pmPefValue)
                        }
                    }
                }
            }
        })
    }

    fun setHubObservle(observle: Any?) {
        when (observle) {
            is AtopyPhotos -> atopyObservle.set(observle)
            is PefInfo -> pefInfoObservle.set(observle)
        }
    }
    @Bindable
    fun getEmpty() : Boolean {
        return atopyPhotoFirst.get() != null
    }

    abstract fun addPefInfo()
    abstract fun addAtopyPhoto()

}