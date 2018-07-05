package com.project.huray.projecthuray.asthma

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.huray.projecthuray.R
import com.project.huray.projecthuray.databinding.FragmentPefinfoBinding

class PefInfoFragment : Fragment() {

    lateinit var viewModel: PefInfoViewModel

    companion object {
        fun newInstance() = PefInfoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_pefinfo, container, false)
        val binding: FragmentPefinfoBinding = FragmentPefinfoBinding.bind(view).apply {
            viewmodel = this@PefInfoFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onLoadPefInfo()
    }

}