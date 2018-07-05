package com.project.huray.projecthuray.data.source.hub

import com.project.huray.projecthuray.data.realm.AtopyPhotos
import com.project.huray.projecthuray.data.realm.PefInfo

object HubDataRepository : HubDataResource {

//    val hubLocalData: HubLocalData by lazy {
//        HubLocalData()
//    }

    val hubRealmData: HubRealmData by lazy {
        HubRealmData()
    }

    override fun setDateKey(key: String) {
        hubRealmData.setDateKey(key)
    }

    override fun getDateKey(): String {
        return hubRealmData.getDateKey()
    }

    override fun getAtopyDatas(atopyPhotos: (List<AtopyPhotos>) -> Unit) {
        hubRealmData.getAtopyDatas(atopyPhotos)
    }

    override fun setAtopyData(atopyPhotos: AtopyPhotos) {
        hubRealmData.setAtopyData(atopyPhotos)
    }

    override fun getAtopyData(date: String): AtopyPhotos? = hubRealmData.getAtopyData(date)

    override fun getAsthmaDatas(pefInfo: (List<PefInfo>) -> Unit) {
        hubRealmData.getAsthmaDatas(pefInfo)
    }

    override fun setAsthmaData(pefInfo: PefInfo) {
        hubRealmData.setAsthmaData(pefInfo)
    }

    override fun getAsthmaData(date: String): PefInfo? = hubRealmData.getAsthmaData(date)

}