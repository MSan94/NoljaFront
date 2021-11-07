package com.prj.nolja.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity.START
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.prj.nolja.R
import com.prj.nolja.databinding.ActivityHomeBinding
import com.prj.nolja.view.dialog.WriteDialog
import com.prj.nolja.view.fragment.CommentFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding
    private var mDrawerToggle : ActionBarDrawerToggle? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        mDrawerToggle = ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.open,R.string.close)
        mDrawerToggle!!.syncState()
        init()
        eventTask()
        setFragment(CommentFragment())

    }

    @SuppressLint("ResourceAsColor")
    private fun init(){

        btn_write.setOnClickListener {
            var dialog = WriteDialog()
            dialog.show(supportFragmentManager,"")
        }

        linearLayout_button1.setOnClickListener {
            Log.d("TestApp","1")
            linearLayout_button1.setBackgroundColor(R.color.black)
            linearLayout_button2.setBackgroundColor(R.color.white)
            linearLayout_button3.setBackgroundColor(R.color.white)
        }
        linearLayout_button2.setOnClickListener {
            Log.d("TestApp","2")
            linearLayout_button1.setBackgroundColor(R.color.white)
            linearLayout_button2.setBackgroundColor(R.color.black)
            linearLayout_button3.setBackgroundColor(R.color.white)
        }
        linearLayout_button3.setOnClickListener {
            Log.d("TestApp","3")
            linearLayout_button1.setBackgroundColor(R.color.white)
            linearLayout_button2.setBackgroundColor(R.color.white)
            linearLayout_button3.setBackgroundColor(R.color.black)
        }

    }

    /** 이벤트 모음 **/
    private fun eventTask(){
        textView_Menu1.setOnClickListener {
            setFragment(CommentFragment())
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

    private fun setFragment(fragment : Fragment){
        Log.d("TestApp", "들어옴")
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_fragment,fragment)
            .commit()

    }
}