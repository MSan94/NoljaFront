package com.prj.nolja.data.repository.user

import com.prj.nolja.data.model.UserModel
import com.prj.nolja.data.repository.retrofit.RetrofitObject

object UserRepository {
    private val retrofitDataSource = UserRemoteDataSource

    fun getMyInfo(userName : String, userPassword : String, callback:getDataCallback<UserModel>){
        retrofitDataSource.getMyInfo()
    }

    interface getDataCallback<T>{
        fun onSuccess(data : T?)
        fun onFailure(throwable: Throwable)
    }
}//https://0391kjy.tistory.com/14