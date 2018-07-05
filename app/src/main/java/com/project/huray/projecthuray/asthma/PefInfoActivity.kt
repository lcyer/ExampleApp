package com.project.huray.projecthuray.asthma

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.huray.projecthuray.R
import com.project.huray.projecthuray.asthma.timepicker.TimePickerFragment
import com.project.huray.projecthuray.data.source.hub.HubDataRepository
import com.project.huray.projecthuray.util.add
import kotlinx.android.synthetic.main.activity_pefinfo.*

class PefInfoActivity : AppCompatActivity(), PefInfoNavigator {

    private val viewModel: PefInfoViewModel by lazy {
        PefInfoViewModel(HubDataRepository)
    }

    companion object {
        const val ADD_PEF_INFO_RESULT_Ok = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pefinfo)

        setToolbar()
        setFragment()
    }

    fun setToolbar() {
        setSupportActionBar(pefToolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.pef_info_input)
        }
    }

    fun setFragment() {
        val pefInfoFragment: PefInfoFragment = PefInfoFragment.newInstance().apply {
            viewModel = this@PefInfoActivity.viewModel
        }
        viewModel.navigator = this@PefInfoActivity
        add(R.id.container, pefInfoFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onTimePicker() {
        val timePicker = TimePickerFragment.newInstance().apply {
            viewModel = this@PefInfoActivity.viewModel
            show(supportFragmentManager, null)
        }
    }

    override fun onPefInfoSaved() {
        setResult(ADD_PEF_INFO_RESULT_Ok);
        finish()
    }

}