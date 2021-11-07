package com.prj.nolja.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prj.nolja.databinding.FragmentCommentBinding
import com.prj.nolja.view.dialog.WriteDialog
import com.prj.nolja.view.viewmodel.CommentViewMode
import kotlinx.android.synthetic.main.fragment_comment.*

class CommentFragment() : Fragment(){
    private var _binding : FragmentCommentBinding? = null
    private val binding get() = _binding!!
    private val viewModel : CommentViewMode by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCommentBinding.inflate(inflater,container,false)
        init()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun init(){
    }

}