package com.project.huray.projecthuray.data.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

public open class PefInfo : RealmObject() {

    public open var date: String? = null

    public open var amTime: String? = null
    public open var amPefValue: String? = null

    public open var pmTime: String? = null
    public open var pmPefValue: String? = null

}