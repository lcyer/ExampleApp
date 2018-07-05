package com.project.huray.projecthuray.data.source.hub

import com.project.huray.projecthuray.data.realm.AtopyPhotos
import com.project.huray.projecthuray.data.realm.PefInfo


interface HubDataResource {

    //날짜키
    fun setDateKey(key: String)
    fun getDateKey(): String

    //아토피
    fun getAtopyDatas(atopyDatas: (List<AtopyPhotos>) -> Unit)
    fun setAtopyData(atopyPhotos: AtopyPhotos)
    fun getAtopyData(date: String): AtopyPhotos?

    //천식
    fun getAsthmaDatas(pefInfo: (List<PefInfo>) -> Unit)
    fun setAsthmaData(pefInfo: PefInfo)
    fun getAsthmaData(date: String): PefInfo?

}