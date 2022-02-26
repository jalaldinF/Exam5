package com.example.localizationdependencies

import android.app.Application
import com.example.localizationdependencies.localMeng.LocalManager

class MyApplication:Application() {

    companion object{
        val TAG = MyApplication::class.java.simpleName
        var instance:MyApplication? = null
        var localeManager:LocalManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        localeManager = LocalManager(this)
        localeManager!!.setLocale(this)
    }

}