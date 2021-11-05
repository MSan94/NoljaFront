package com.prj.nolja

import android.app.Application
import android.content.Context
import android.graphics.Point
import android.view.Window
import android.view.WindowManager
import com.prj.nolja.util.PreferenceUtil

/**
 * 실행 전 체크
 */
class MyApplication:Application(){

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        size = Point()
        super.onCreate()
    }


    companion object{
        lateinit var prefs : PreferenceUtil
        lateinit var size : Point
    }

}