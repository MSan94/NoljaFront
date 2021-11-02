package com.prj.nolja.view

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.prj.nolja.R
import com.prj.nolja.databinding.ActivityJoinBinding
import com.prj.nolja.util.EventObserver
import com.prj.nolja.view.viewmodel.JoinViewModel
import kotlinx.android.synthetic.main.activity_join.*
import org.mindrot.jbcrypt.BCrypt

class JoinActivity : AppCompatActivity() {
    lateinit var binding : ActivityJoinBinding
    private val viewModel : JoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        viewModel.idCheck.observe(this, Observer {
            when(it){
                0 -> {
                    textView_IdCheck_Result.text = "사용가능한 아이디입니다."
                    textView_IdCheck_Result.visibility = VISIBLE
                }
                1 ->{
                    textView_IdCheck_Result.text = "이미 사용중인 아이디입니다."
                    textView_IdCheck_Result.visibility = VISIBLE
                }
            }
        })

        viewModel.joinResult.observe(this, Observer {
            when(it){
                1 -> {
                    Toast.makeText(this,"회원가입 성공",Toast.LENGTH_SHORT).show()
                    moveActivity("1")
                }
                0 -> {
                    Toast.makeText(this,"회원가입에 실패하였습니다. 관리자에게 문의해주세요.",Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.err.observe(this, EventObserver { message ->
            Toast.makeText(this,"$message",Toast.LENGTH_SHORT).show()
        })

    }

    fun moveActivity(type:String){
        when(type){
            "1" -> {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

}