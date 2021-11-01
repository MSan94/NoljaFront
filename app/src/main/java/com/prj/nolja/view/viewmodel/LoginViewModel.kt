package com.prj.nolja.view.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import com.prj.nolja.base.BaseViewModel
import com.prj.nolja.data.model.UserModel
import com.prj.nolja.data.repository.user.UserRepository

class LoginViewModel : BaseObservable() {
    val userNick = ObservableField<String>()

    fun getMyInfo(userIdx : Integer){
        UserRepository.getMyInfo(userIdx, object : UserRepository.getDataCallback<UserModel>{
            override fun onSuccess(data: UserModel?) {
                data?.let {
                    val result = "${it.userNick}"
                    userNick.set(result)
                }
            }

            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }

        })
    }

}