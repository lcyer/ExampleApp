package com.project.huray.projecthuray.util

import com.project.huray.projecthuray.R
import java.text.SimpleDateFormat
import java.util.*

fun nowDate(): Long {
    val date: Date = Date(System.currentTimeMillis())
    return date.time
}

fun getCurYear(): String {
    val format: SimpleDateFormat = SimpleDateFormat("yyyy")
    return format.format(nowDate())
}

fun getCurMonth(): String {
    val format: SimpleDateFormat = SimpleDateFormat("MM")
    return format.format(nowDate())
}

fun getCurDay(): String {
    val format: SimpleDateFormat = SimpleDateFormat("dd")
    return format.format(nowDate())
}

fun getToday(): String {
    val format: SimpleDateFormat = SimpleDateFormat("yyyyMMdd")
    return format.format(nowDate())
}

fun getWeekDay(day: Int): Date {
    val calendar: Calendar = Calendar.getInstance()
    when (day) {
        R.string.monday -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
        R.string.tuesday -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY)
        R.string.wednesday -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY)
        R.string.thursday -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY)
        R.string.friday -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY)
        R.string.saturday -> calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
        R.string.sunday -> {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
            calendar.add(Calendar.DATE, 7)
        }
    }
    return calendar.time
}

fun Date.fixDatetoDay(): String {
    val format: SimpleDateFormat = SimpleDateFormat("yyyyMMdd")
    val fixday = format.format(this).substring(6, 8)
    return fixday
}

fun Date.fixDate(): String {
    val format: SimpleDateFormat = SimpleDateFormat("yyyyMMdd")
    return format.format(this)
}

fun String.fixDatetoKor(): String {
    return String.format("%s년 %s월 %s일", substring(0, 4), substring(4, 6), substring(6,8), this)
}






