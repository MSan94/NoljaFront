package com.prj.nolja

import android.app.Application
import com.prj.nolja.util.PreferenceUtil

/**
 * 실행 전 체크
 */
class MyApplication:Application(){

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }

    companion object{
        lateinit var prefs : PreferenceUtil
    }

}