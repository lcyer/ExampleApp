package com.project.huray.projecthuray.data.realm

import android.net.Uri
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

public open class AtopyPhotos : RealmObject() {

    public open var date: String? = null

    public open var photoFirst: String? = null
    public open var photoSecond: String? = null
    public open var photoThird: String? = null

}