/*
package com.project.huray.projecthuray.data.source.hub

import android.util.Log
import com.project.huray.projecthuray.data.fake.AsthmaData
import com.project.huray.projecthuray.data.fake.AsthmaDatas
import com.project.huray.projecthuray.data.fake.AtopyData

class HubLocalData : HubDataResource {

    override fun getAtopyDatas(atopyDatas: (List<AtopyData>) -> Unit) {
        val fakeAtopyDatas = mutableListOf<AtopyData>()
        val fakeAtopyData = AtopyData(
            "20180605",
            mutableListOf(
                "photo3",
                "photo2",
                "photo1"
            )
        )
        fakeAtopyDatas.add(0, fakeAtopyData)

        //CACHE_ATOPY_DATAS.filter { it == null }.map { fakeAtopyDatas }

        atopyDatas(fakeAtopyDatas)
    }

    override fun setAtopyData(atopyData: AtopyData) {
        //insert ex 20180605 key -> AtopyData()
        for (i in atopyData.atopyImages) {
            Log.d("cylee", "local set - $i")
        }
    }

    override fun getAtopyData(date: String): AtopyData {
        //selet atopy from date ---> 현재날짜 기준으로 찾는다.
        return AtopyData("", mutableListOf())
    }

    override fun delAtopyData(date: String) {
        //delete atopy from date
        Log.d("cylee", "local delAtopyData Date - $date")
    }

    override fun getAsthmaDatas(asthmaDatas: (List<AsthmaDatas>) -> Unit) {
        val fakeAsthmaDatas = mutableListOf<AsthmaData>()
        val fakeAsthmaDataAm = AsthmaData("am", "08:00", "300")
        val fakeAsthmaDataPm = AsthmaData("pm", "18:00", "400")

        fakeAsthmaDatas.add(0, fakeAsthmaDataAm)
        fakeAsthmaDatas.add(1, fakeAsthmaDataPm)

        val fakeDats = mutableListOf<AsthmaDatas>()
        fakeDats.add(AsthmaDatas("20180605", fakeAsthmaDatas))

        asthmaDatas(fakeDats)
    }

    override fun setAsthmaData(asthmaDatas: List<AsthmaData>) {
        //insert ex 20180605 key -> AtopyData()
        for ((index) in asthmaDatas.withIndex()) {
            Log.d("cylee", "local set i - $index amPm - ${asthmaDatas[index].amPm}")
            Log.d("cylee", "local set i - $index time - ${asthmaDatas[index].time}")
            Log.d("cylee", "local set i - $index pef - ${asthmaDatas[index].pef}")
        }
    }

    override fun getAsthmaData(date: String): List<AsthmaData> {
        return mutableListOf(
            AsthmaData("am", "08:00", "300"),
            AsthmaData("pm", "18:00", "400")
        )
    }

    override fun delAsthmaData(date: String, amPm: String) {
        Log.d("cylee", "local delAsthmaData Date - $date amPm - $amPm")
    }

}*/
