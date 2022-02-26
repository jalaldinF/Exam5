package com.example.localizationdependencies

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localizationdependencies.localMeng.LocalManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       initView()

    }
 fun initView(){

     btn_eng.text = getString(R.string.lan_english)
     btn_rus.text = getString(R.string.lan_russian)
     btn_uzb.text = getString(R.string.lan_uzbek)

     btn_eng.setOnClickListener {

         MyApplication.localeManager!!.setNewLocale(this,LocalManager.LANGUAGE_ENGLISH)
         finish()

     /*setLocel("en")*/  }
     btn_rus.setOnClickListener {/* setLocel("ru")*/
         MyApplication.localeManager!!.setNewLocale(this,LocalManager.LANGUAGE_RUSSIAN)
         finish()}
     btn_uzb.setOnClickListener { /*setLocel("uz")*/
        val intent = Intent(this,PreferenceAct::class.java)
         startActivity(intent)
     }


  }

    private fun setLocel(s: String) {
        val locale = Locale(s)
        Locale.setDefault(locale)

        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)
        finish()
    }
}
