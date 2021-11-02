package com.prj.nolja.view.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prj.nolja.base.BaseViewModel
import com.prj.nolja.data.model.User
import com.prj.nolja.data.model.UserModel
import com.prj.nolja.data.repository.user.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val valid = MutableLiveData<Boolean>()
    val resultText = MutableLiveData<String>()

    fun selectUser(id:String, pw:String){
        UserRepository.selectUser(id,pw, object : UserRepository.getDataCallback<User>{
            override fun onSuccess(data: User?) {
                data?.let {
                    valid.value = !(it.result).equals("fail")
                    resultText.value = it.result
                }
            }

            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }

        })
    }



}