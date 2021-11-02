package com.prj.nolja.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.prj.nolja.R
import com.prj.nolja.data.model.UserModel
import com.prj.nolja.databinding.ActivityLoginBinding
import com.prj.nolja.view.viewmodel.LoginViewModel
import org.mindrot.jbcrypt.BCrypt

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    private var resultText : MutableLiveData<String> = MutableLiveData()
    private val viewModel : LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        viewModel.resultText.observe(this, Observer {
            when(it){
                "success" -> {
                    Toast.makeText(this,"성공",Toast.LENGTH_SHORT).show()
                    moveActivity("1")
                }
                else -> {Toast.makeText(this,"실패",Toast.LENGTH_SHORT).show()}
            }
        })
        
    }

    fun moveActivity(type : String){
        when(type){
            "1" -> {
                val intent = Intent(this, JoinActivity::class.java)
                startActivity(intent)
            }
            else -> {

            }
        }
    }
    fun observerViewModel(){
        resultText.observe(this, Observer {
            
        })
    }


    companion object {
        fun getDigestSalt(password: String): String {
            return BCrypt.hashpw(password, BCrypt.gensalt(10))
        }

    }

}

/*val validPassword = BCrypt.checkpw("myPassword", bCryptPassword)
//        Toast.makeText(this,"$validPassword",Toast.LENGTH_SHORT).show()
btn_Login.setOnClickListener {
    val bCrypyPassword = LoginActivity.getDigestSalt(editText_Pw.text.toString())
    Toast.makeText(this, "$bCrypyPassword", Toast.LENGTH_SHORT).show()
}*/


