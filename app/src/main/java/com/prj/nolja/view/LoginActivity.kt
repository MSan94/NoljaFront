package com.prj.nolja.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.prj.nolja.R
import com.prj.nolja.base.BaseActivity
import com.prj.nolja.databinding.ActivityLoginBinding
import com.prj.nolja.view.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.mindrot.jbcrypt.BCrypt
import java.security.MessageDigest

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.run {
            viewmodel = LoginViewModel()
            userIdx = 1
        }
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
