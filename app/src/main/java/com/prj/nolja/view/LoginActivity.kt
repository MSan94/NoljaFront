package com.prj.nolja.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.prj.nolja.R
import com.prj.nolja.databinding.ActivityLoginBinding
import com.prj.nolja.view.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var resultText: MutableLiveData<String> = MutableLiveData()
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        eventTask()
        /** 로그인 유무 옵저버 **/
        viewModel.resultText.observe(this, Observer {
            when (it) {
                "success" -> {
                    Toast.makeText(this, "로그인 하였습니다.", Toast.LENGTH_SHORT).show()
                    moveActivity("2")
                }
                else -> {
                    Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    /** 이벤트 모음 **/
    fun eventTask() {
        btn_Join.setOnClickListener {
            moveActivity("1")
        }
    }

    /** 액티비티 전환 **/
    fun moveActivity(type: String) {
        when (type) {
            "1" -> {
                val intent = Intent(this, JoinActivity::class.java)
                startActivity(intent)
            }
            "2" -> {
                val intent = Intent(this, HomeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }
}



