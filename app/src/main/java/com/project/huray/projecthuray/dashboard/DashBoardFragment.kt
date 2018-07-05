package com.project.huray.projecthuray.dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.huray.projecthuray.MainActivity
import com.project.huray.projecthuray.R
import com.project.huray.projecthuray.dashboard.adapter.DashBoardAdapter
import kotlinx.android.synthetic.main.fragment_dash.*

class DashBoardFragment() : Fragment() {

    lateinit var dashViewModel: DashViewModel

    val dashBoardAdapter: DashBoardAdapter by lazy {
        DashBoardAdapter(this@DashBoardFragment.context, (activity as MainActivity))
    }

    companion object {
        fun newInstance() = DashBoardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dash, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.run {
            adapter = dashBoardAdapter
        }
        dashViewModel.dashAdapterModel = dashBoardAdapter
        dashViewModel.onLoadDashItem()
    }

}

