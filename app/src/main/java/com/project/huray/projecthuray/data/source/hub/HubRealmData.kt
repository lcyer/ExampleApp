package com.project.huray.projecthuray.data.source.hub

import android.util.Log
import com.project.huray.projecthuray.data.realm.AtopyPhotos
import com.project.huray.projecthuray.data.realm.PefInfo
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults

class HubRealmData : HubDataResource {

    private val realm = Realm.getDefaultInstance()

    lateinit var datekey : String

    override fun setDateKey(key: String) {
        datekey = key
    }

    override fun getDateKey(): String {
        return datekey
    }

    override fun getAtopyDatas(atopyPhotos: (List<AtopyPhotos>) -> Unit) {
        val returnAtopyPhotos = mutableListOf<AtopyPhotos>()
        val result: RealmResults<AtopyPhotos> = realm.where(AtopyPhotos::class.java).findAllAsync()

        result.forEach {
            returnAtopyPhotos.add(it)
        }

        atopyPhotos(returnAtopyPhotos)
    }

    override fun setAtopyData(atopyPhotos: AtopyPhotos) {
        realm.beginTransaction()
        if (realm.where(AtopyPhotos::class.java).equalTo("date",atopyPhotos.date).count().toInt() == 0) {
            val atopyPhoto = realm.createObject(AtopyPhotos::class.java).apply {
                date = atopyPhotos.date
                photoFirst = atopyPhotos.photoFirst
                photoSecond = atopyPhotos.photoSecond
                photoThird = atopyPhotos.photoThird
            }
        } else { //update
            val atopyPhoto = realm.where(AtopyPhotos::class.java).equalTo("date",atopyPhotos.date).findFirst()
            atopyPhoto?.run {
                photoFirst = atopyPhotos.photoFirst
                photoSecond = atopyPhotos.photoSecond
                photoThird = atopyPhotos.photoThird
            }
        }
        realm.commitTransaction()
    }

    override fun getAtopyData(date: String): AtopyPhotos? {
        return realm.where(AtopyPhotos::class.java)
            .equalTo("date", date)
            .findFirst()
    }

    override fun getAsthmaDatas(pefInfo: (List<PefInfo>) -> Unit) {
        val returnPefInfo = mutableListOf<PefInfo>()
        val result: RealmResults<PefInfo> = realm.where(PefInfo::class.java).findAllAsync()

        result.forEach {
            returnPefInfo.add(it)
        }

        pefInfo(returnPefInfo)
    }

    override fun setAsthmaData(info: PefInfo) {
        realm.beginTransaction()
        if (realm.where(PefInfo::class.java).equalTo("date",info.date).count().toInt() == 0) {
            val pefInfo = realm.createObject(PefInfo::class.java).apply {
                date = info.date

                info.amTime?.let {
                    amTime = info.amTime
                    amPefValue = info.amPefValue
                }

                info.pmTime?.let {
                    pmTime = info.pmTime
                    pmPefValue = info.pmPefValue
                }
            }
        } else { //update
            val perInfo = realm.where(PefInfo::class.java).equalTo("date",info.date).findFirst()
            perInfo?.run {
                amTime = info.amTime
                amPefValue = info.amPefValue
                pmTime = info.pmTime
                pmPefValue = info.pmPefValue
            }
        }
        realm.commitTransaction()
    }

    override fun getAsthmaData(date: String): PefInfo? {
        return realm.where(PefInfo::class.java)
            .equalTo("date", date)
            .findFirst()
    }

}