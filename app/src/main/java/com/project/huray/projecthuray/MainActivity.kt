package com.project.huray.projecthuray

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.project.huray.projecthuray.asthma.PefInfoActivity
import com.project.huray.projecthuray.atopy.AtopyPhotoActivity
import com.project.huray.projecthuray.dashboard.DashBoardFragment
import com.project.huray.projecthuray.dashboard.DashViewModel
import com.project.huray.projecthuray.dashboard.HubNavigator
import com.project.huray.projecthuray.data.source.hub.HubDataRepository
import com.project.huray.projecthuray.databinding.ActivityMainBinding
import com.project.huray.projecthuray.util.add
import com.project.huray.projecthuray.util.doRequestPermission
import com.project.huray.projecthuray.util.selctedColor
import com.project.huray.projecthuray.util.unSelected
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dashboard_calender.*

class MainActivity : AppCompatActivity(), HubNavigator {

    val dashViewModel: DashViewModel by lazy {
        DashViewModel(HubDataRepository)
    }

    companion object {
        const val REQUSET_MAIN_ACTIVITY = 7
        const val PERMISSION_REQUEST_EXTERNAL_READ = 8
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.viewmodel = dashViewModel

        setToolbar()
        setDrawer()

        dashViewModel.navigator = this@MainActivity
        dashViewModel.initCalendar()

        setDashFragment()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> drawLayout.openDrawer(Gravity.START)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            PefInfoActivity.ADD_PEF_INFO_RESULT_Ok -> dashViewModel.onLoadDashItem()
            AtopyPhotoActivity.ADD_ATOPY_PHOTO_RESULT_Ok -> dashViewModel.onLoadDashItem()
        }
    }

    fun setToolbar() {
        toolbar.run {
            setSupportActionBar(toolbar)
            overflowIcon = ContextCompat.getDrawable(
                getApplicationContext(),
                R.drawable.ic_email_black_24dp
            )

            supportActionBar?.run {
                setHomeAsUpIndicator(R.drawable.ic_menu)
                setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    fun setDrawer() {
        navigationView?.run {
            setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.atopyPhotoItem -> addAtopyPhoto()
                    R.id.pefInfoItem -> addPefInfo()
                }
                drawLayout.closeDrawers()
                true
            }
        }
    }

    fun setDashFragment() {
        val dashFragment: DashBoardFragment = DashBoardFragment.newInstance().apply {
            dashViewModel = this@MainActivity.dashViewModel
        }
        add(R.id.mainContainer, dashFragment)
    }

    override fun showNowDate(days: Int) {
        when (days) {
            R.string.monday -> tvMonTitle.selctedColor(tvMon) //onClickDayWithLoadContents(layoutMon)
            R.string.tuesday -> tvTueTitle.selctedColor(tvTue) //onClickDayWithLoadContents(layoutTue)
            R.string.wednesday -> tvWedTitle.selctedColor(tvWed) //onClickDayWithLoadContents(layoutWed)
            R.string.thursday -> tvThuTitle.selctedColor(tvThu) //onClickDayWithLoadContents(layoutThu)
            R.string.friday -> tvFriTitle.selctedColor(tvFri) //onClickDayWithLoadContents(layoutFri)
            R.string.saturday -> tvSatTitle.selctedColor(tvSat) //onClickDayWithLoadContents(layoutSat)
            R.string.sunday -> tvSunTitle.selctedColor(tvSun) //onClickDayWithLoadContents(layoutSun)
        }
    }

    override fun onClickDayWithLoadContents(view: View) {
        val unSelectedList = mutableListOf<View>(
            tvMonTitle,
            tvMon,
            tvTue,
            tvTueTitle,
            tvWed,
            tvWedTitle,
            tvThu,
            tvThuTitle,
            tvFri,
            tvFriTitle,
            tvSat,
            tvSatTitle,
            tvSun,
            tvSunTitle
        ).unSelected()

        when (view.id) {
            R.id.layoutMon -> {
                tvMonTitle.selctedColor(tvMon)
                dashViewModel.makeDateKey(R.string.monday)
            }
            R.id.layoutTue -> {
                tvTueTitle.selctedColor(tvTue)
                dashViewModel.makeDateKey(R.string.tuesday)
            }
            R.id.layoutWed -> {
                tvWedTitle.selctedColor(tvWed)
                dashViewModel.makeDateKey(R.string.wednesday)
            }
            R.id.layoutThu -> {
                tvThuTitle.selctedColor(tvThu)
                dashViewModel.makeDateKey(R.string.thursday)
            }
            R.id.layoutFri -> {
                tvFriTitle.selctedColor(tvFri)
                dashViewModel.makeDateKey(R.string.friday)
            }
            R.id.layoutSat -> {
                tvSatTitle.selctedColor(tvSat)
                dashViewModel.makeDateKey(R.string.saturday)
            }
            R.id.layoutSun -> {
                tvSunTitle.selctedColor(tvSun)
                dashViewModel.makeDateKey(R.string.sunday)
            }
        }

        //load data
        dashViewModel.onLoadDashItem()
    }

    override fun addPefInfo() {
        startActivityForResult(Intent(this, PefInfoActivity::class.java), REQUSET_MAIN_ACTIVITY)
    }

    override fun addAtopyPhoto() {
        startActivityForResult(Intent(this, AtopyPhotoActivity::class.java), REQUSET_MAIN_ACTIVITY)
    }

    //permission
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_EXTERNAL_READ -> dashViewModel.onLoadDashItem()
        }
    }

}
