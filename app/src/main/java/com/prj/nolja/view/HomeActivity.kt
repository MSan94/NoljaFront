package com.prj.nolja.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity.START
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.prj.nolja.R
import com.prj.nolja.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding
    private var mDrawerToggle : ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        mDrawerToggle = ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.open,R.string.close)
        mDrawerToggle!!.syncState()

        eventTask()

    }

    /** 이벤트 모음 **/
    fun eventTask(){
        textView_Menu1.setOnClickListener {
            update("1")
        }
        textView_Menu2.setOnClickListener {
            update("2")
        }
        textView_Menu3.setOnClickListener {
            update("3")
        }
    }

    @SuppressLint("WrongConstant")
    fun update(type:String){
        drawer_layout!!.closeDrawer(START)
        Toast.makeText(this,type,Toast.LENGTH_SHORT).show()

        //TODO 프래그먼트 전환

    }
}