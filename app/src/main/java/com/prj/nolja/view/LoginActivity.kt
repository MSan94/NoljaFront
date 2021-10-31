package com.prj.nolja.view

import android.widget.Toast
import com.prj.nolja.R
import com.prj.nolja.base.BaseActivity
import com.prj.nolja.databinding.ActivityLoginBinding
import com.prj.nolja.view.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_login
    override val viewModel : LoginViewModel by viewModel()

    override fun initStartView() {
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
        btn_Login.setOnClickListener {
            Toast.makeText(this,"클릭됨",Toast.LENGTH_SHORT).show()
        }
    }

}