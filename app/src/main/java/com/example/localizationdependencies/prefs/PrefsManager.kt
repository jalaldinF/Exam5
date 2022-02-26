package com.example.localizationdependencies.prefs

import android.content.Context
import android.content.SharedPreferences

class PrefsManager private constructor(context: Context) {

    private val sharedPreferences:SharedPreferences?

    companion object{
        private var prefsManager:PrefsManager? = null
    fun  getInstance(context: Context):PrefsManager?{
        if (prefsManager == null){
          prefsManager = PrefsManager(context)
        }
        return prefsManager
     }

  }
    init {
        sharedPreferences = context.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE)
    }

    fun saveData(key:String?,value:String?){
    val prefsEditor = sharedPreferences!!.edit()
    prefsEditor.commit()
    }
    fun getData(key:String):String?{
        return if (sharedPreferences != null) sharedPreferences.getString(key,"") else "en"
    }
}