package com.project.huray.projecthuray.dashboard

import android.view.View

interface HubNavigator{

    fun onClickDayWithLoadContents(view: View)
    fun showNowDate(days: Int)
    fun addPefInfo()
    fun addAtopyPhoto()
}