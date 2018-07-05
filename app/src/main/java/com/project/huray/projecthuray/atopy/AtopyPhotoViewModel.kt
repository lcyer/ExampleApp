package com.project.huray.projecthuray.atopy

import com.project.huray.projecthuray.data.realm.AtopyPhotos
import com.project.huray.projecthuray.data.source.hub.HubDataRepository

class AtopyPhotoViewModel(
    repository: HubDataRepository
) : PhotoViewModel(repository) {

    lateinit var navigator: AtopyPhotoNavigator

    override fun doTakeAlbum() {
        navigator.doTakeAlbum()
    }

    override fun onPhotoSaved() {
        val item = AtopyPhotos().apply {
            date = repository.getDateKey()

            photoFirst = photoMapList.get(1)
            photoSecond = photoMapList.get(2)
            photoThird = photoMapList.get(3)
        }
        repository.setAtopyData(item)
        navigator.onPhotoSaved()
    }

}