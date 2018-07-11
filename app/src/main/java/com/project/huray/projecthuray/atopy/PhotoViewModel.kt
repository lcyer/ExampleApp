package com.project.huray.projecthuray.atopy

import android.databinding.*
import android.util.SparseArray
import com.project.huray.projecthuray.BR
import com.project.huray.projecthuray.data.source.hub.HubDataRepository
import com.project.huray.projecthuray.util.fixDatetoKor

abstract class PhotoViewModel(
    val repository: HubDataRepository
) : BaseObservable() {

    val dateTitle: ObservableField<String> = ObservableField()

    var photoCnt: Int = 1
    val photoList: ObservableList<String> = ObservableArrayList()
    val photo: ObservableField<String> = ObservableField()
    val photoMapList = mutableMapOf<Int, String?>()

    /**
     * todo list
     **/
    fun onLoadPhoto() {
        photoList.clear()
        photoMapList.clear()
        dateTitle.set(repository.getDateKey().fixDatetoKor())
        val photoItems = repository.getAtopyData(repository.getDateKey())?.apply {
            photoFirst?.let {
                photoList.add(it)
                photo.set(it)
                photoMapList.set(photoList.size, photoFirst)
            }
            photoSecond?.let {
                photoList.add(it)
                photoMapList.set(photoList.size, photoSecond)
            }
            photoThird?.let {
                photoList.add(it)
                photoMapList.set(photoList.size, photoThird)
            }
        }
    }

    fun onAddPhoto(imageUri: String?) {
        photoList.takeIf { it.size < 3 }?.apply {
            if (size == 0) {
                photoList.add(imageUri)
                photo.set(imageUri)
            } else {
                photoList.add((imageUri))
            }
            photoMapList.set(photoList.size, imageUri)
        }
        notifyPropertyChanged(BR.curPhotoCnt)
    }

    @Bindable
    fun getCurPhotoCnt() = if (photoList.size > 0) photoCnt.toString() else "0"

    fun onNextPhoto() {
        photoList.takeIf { it.size > photoCnt }?.apply { photo.set(photoMapList.get(++photoCnt)) }
        notifyPropertyChanged(BR.curPhotoCnt)
    }

    fun onPrevPhoto() {
        photoCnt.takeIf { it > 1 }?.apply { photo.set(photoMapList.get(--photoCnt)) }
        notifyPropertyChanged(BR.curPhotoCnt)
    }

    fun onDeletePhoto() {
        //val s = SparseArray<String>()
        photoMapList.clear()
        photoList.removeAt(photoCnt - 1)
        for ((index, value) in photoList.withIndex()) {
            photoMapList.set(index + 1, value)
        }
        photoCnt.takeIf { it > 1 }?.apply { photoCnt-- }
        photo.set(photoMapList.get(photoCnt))
        notifyPropertyChanged(BR.curPhotoCnt)
    }

    abstract fun doTakeAlbum()
    abstract fun onPhotoSaved()

}
