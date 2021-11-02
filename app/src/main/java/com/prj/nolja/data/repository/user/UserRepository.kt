package com.prj.nolja.data.repository.user

import com.prj.nolja.data.model.User
import com.prj.nolja.data.model.UserModel
import com.prj.nolja.data.repository.retrofit.RetrofitObject

object UserRepository {
    private val retrofitDataSource = UserRemoteDataSource

    /**
     * 회원정보 가져오기
     */
    fun selectUser(id:String, pw:String, callback:getDataCallback<User>){
        retrofitDataSource.selectUser(id, pw, callback)
    }

    /**
     * 데이터 콜백
     */
    interface getDataCallback<T>{
        fun onSuccess(data : T?)
        fun onFailure(throwable: Throwable)
    }
}