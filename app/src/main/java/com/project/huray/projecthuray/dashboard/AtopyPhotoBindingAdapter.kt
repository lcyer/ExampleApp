package com.project.huray.projecthuray.dashboard

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imgRes")
fun atopyPhotoLoad(view: ImageView, imgUrl: Any?) {
    imgUrl?.let {
        //view.visibility = View.VISIBLE
        Glide.with(view.getContext()).load(it)
            .into(view)
    } ?: view?.let {
        //view.visibility = View.GONE
        view.setImageResource(0)
    }
}
