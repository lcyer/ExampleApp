package com.project.huray.projecthuray.dashboard

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imgRes")
fun atopyPhotoLoad(view: ImageView, imgUrl: Any?) {
    //view.visibility = View.VISIBLE
    Glide.with(view.getContext())
        .load(imgUrl)
        .error(Glide.with(view).load(0))
        .into(view)
}
