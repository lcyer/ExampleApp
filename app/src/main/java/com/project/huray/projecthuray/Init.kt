package com.project.huray.projecthuray

import android.app.Application
import io.realm.Realm

class Init : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

}