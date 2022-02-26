package com.example.localizationdependencies

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localizationdependencies.model.Member
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_preference.*

class PreferenceAct : AppCompatActivity() {
    lateinit var mPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        initViews()
    }
    @SuppressLint("SetTextI18n")
    fun initViews(){
        btn_save.setOnClickListener {
            val name = et_fullname.text.toString()
            val age = et_age.text.toString()
            val mem = Member(name,age = age.toInt())
                putObj(mem)
            tv_data_show.text = getObj()?.fullname.toString()+"\n"+getObj()?.age.toString()

        }

    }
    @SuppressLint("CommitPrefEdits")
    fun putObj(member: Member){
        val gson = Gson()
         val json:String = gson.toJson(member)
        mPrefs = applicationContext.getSharedPreferences("Mypref",MODE_PRIVATE)
         val prefEditor = mPrefs.edit()
        prefEditor.putString("Obj",json)
        prefEditor.apply()

    }

    fun getObj(): Member? {

        val gson = Gson()
        val json: String? = mPrefs.getString("Obj", "")

        return gson.fromJson(json, Member::class.java)
    }

    private fun saveEmail(em:String?) {
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("email",em)
        editor.apply()
    }

    fun loadEmail():String?{
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        return prefs.getString("email","pdp@gmail.com")
    }
    fun removeEmail(){
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.remove("email")
        editor.apply()
    }
    fun clearAll(){
        val prefs = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}