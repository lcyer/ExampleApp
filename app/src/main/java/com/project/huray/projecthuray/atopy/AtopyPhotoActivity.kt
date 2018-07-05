package com.project.huray.projecthuray.atopy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.huray.projecthuray.R
import com.project.huray.projecthuray.data.source.hub.HubDataRepository
import com.project.huray.projecthuray.util.add
import kotlinx.android.synthetic.main.activity_atopy_photo.*

class AtopyPhotoActivity : AppCompatActivity(), AtopyPhotoNavigator {

    var imageUri: String? = null

    val viewModel: AtopyPhotoViewModel by lazy {
        AtopyPhotoViewModel(HubDataRepository)
    }

    companion object {
        const val PICK_FROM_ALBUM = 1
        const val ADD_ATOPY_PHOTO_RESULT_Ok = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atopy_photo)

        setToolbar()
        setFragment()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        resultCode.takeIf { it == Activity.RESULT_OK }?.apply {
            when (requestCode) {
                PICK_FROM_ALBUM -> {
                    imageUri = data?.data.toString()
                    viewModel.onAddPhoto(imageUri)
                }
            }
        }
    }

    fun setToolbar() {
        setSupportActionBar(atopyToolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.atopy_photo_reg)
        }
    }

    fun setFragment() {
        val fragment = AtopyPhotoFragment.newInstance().apply {
            viewModel = this@AtopyPhotoActivity.viewModel
        }
        viewModel.navigator = this@AtopyPhotoActivity
        add(R.id.container, fragment)
    }

    override fun doTakeAlbum() {
        val intent = Intent().apply {
            setAction(Intent.ACTION_PICK)
            setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE)
        }
        startActivityForResult(intent, PICK_FROM_ALBUM)
    }

    override fun onPhotoSaved() {
        setResult(ADD_ATOPY_PHOTO_RESULT_Ok)
        finish()
    }

}