package com.project.huray.projecthuray.atopy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.huray.projecthuray.R
import com.project.huray.projecthuray.databinding.FragmentAtopyPhotoBinding

class AtopyPhotoFragment : Fragment() {

    lateinit var viewModel: AtopyPhotoViewModel

    companion object {
        fun newInstance() = AtopyPhotoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_atopy_photo, container, false)
        val binding = FragmentAtopyPhotoBinding.bind(view).apply {
            viewmodel = this@AtopyPhotoFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onLoadPhoto()
    }

}