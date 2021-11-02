package com.prj.nolja.data.repository.user

import com.prj.nolja.data.model.User
import com.prj.nolja.data.model.UserModel
import com.prj.nolja.data.repository.retrofit.RetrofitObject

object UserRepository {
    private val retrofitDataSource = UserRemoteDataSource

    /**
     * 로그인 체크
     */
    fun selectUser(id:String, pw:String, callback:getDataCallback<User>){
        retrofitDataSource.selectUser(id, pw, callback)
    }

    /**
     * 아이디 중복 체크
     */
    fun validUserId(id:String){

    }


    /**
     * 데이터 콜백
     */
    interface getDataCallback<T>{
        fun onSuccess(data : T?)
        fun onFailure(throwable: Throwable)
    }
}