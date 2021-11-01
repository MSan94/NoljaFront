package com.prj.nolja.view

import android.widget.Toast
import com.prj.nolja.R
import com.prj.nolja.base.BaseActivity
import com.prj.nolja.databinding.ActivityLoginBinding
import com.prj.nolja.view.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.mindrot.jbcrypt.BCrypt
import java.security.MessageDigest

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_login
    override val viewModel : LoginViewModel by viewModel()

    override fun initStartView() {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
//        val validPassword = BCrypt.checkpw("myPassword", bCryptPassword)

//        Toast.makeText(this,"$validPassword",Toast.LENGTH_SHORT).show()
        btn_Login.setOnClickListener {
            val bCrypyPassword = getDigestSalt(editText_Pw.text.toString())
            Toast.makeText(this,"$bCrypyPassword",Toast.LENGTH_SHORT).show()
        }
    }

    companion object{
        fun getDigestSalt(password : String):String{
            return BCrypt.hashpw(password, BCrypt.gensalt(10))
        }

    }

}