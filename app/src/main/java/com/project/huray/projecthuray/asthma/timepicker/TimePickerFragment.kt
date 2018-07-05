package com.project.huray.projecthuray.asthma.timepicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.format.DateFormat
import android.util.Log
import android.widget.TimePicker
import com.project.huray.projecthuray.asthma.PefInfoViewModel
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    lateinit var viewModel: PefInfoViewModel

    companion object {
        fun newInstance() = TimePickerFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val min = cal.get(Calendar.MINUTE)
        val timePickerDialog: TimePickerDialog =
            TimePickerDialog(context, this, hour, min, DateFormat.is24HourFormat(context))

        return timePickerDialog
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        viewModel.setTimePicker(hourOfDay, minute)
    }

}