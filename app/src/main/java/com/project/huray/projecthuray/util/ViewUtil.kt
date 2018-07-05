package com.project.huray.projecthuray.util

import android.graphics.Color
import android.view.View
import android.widget.TextView

fun View.selctedColor(view: View){
    (this as? TextView)?.setTextColor(Color.BLUE)
    (view as? TextView)?.setTextColor(Color.BLUE)
}

fun List<View>.unSelected(){
    this.forEach {
        (it as TextView).setTextColor(Color.BLACK)
    }
}




