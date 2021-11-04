package com.prj.nolja.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context : Context) {
    private val prefs : SharedPreferences = context.getSharedPreferences("noljaApp",Context.MODE_PRIVATE)

    fun getString(key:String, value:String) : String {
        return prefs.getString(key,value).toString()
    }

    fun setString(key: String, value:String) {
        prefs.edit().putString(key,value).apply()
    }

    fun deleteString(key : String){
        prefs.edit().remove(key).commit()
    }

}