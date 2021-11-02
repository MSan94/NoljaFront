package com.prj.nolja.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.prj.nolja.R
import com.prj.nolja.databinding.ActivityJoinBinding
import com.prj.nolja.view.viewmodel.JoinViewModel

class JoinActivity : AppCompatActivity() {
    lateinit var binding : ActivityJoinBinding
    private val viewModel : JoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }

}