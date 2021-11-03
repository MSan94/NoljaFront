package com.prj.nolja.data.repository.user

import com.prj.nolja.data.model.CommonModel
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
    fun validUserId(id:String, callback: getDataCallback<CommonModel>){
        retrofitDataSource.validUserId(id,callback)
    }

    /** 회원가입 **/
    fun insertUser(id:String, pw:String, email:String, nick:String, callback: getDataCallback<CommonModel>){
        retrofitDataSource.insertUser(id,pw,email,nick,callback)
    }

    /** 메일 전송 **/
    fun requestMail(receiverMail : String , callback: getDataCallback<CommonModel>){
        retrofitDataSource.requestMail(receiverMail,callback)
    }

    /**
     * 데이터 콜백
     */
    interface getDataCallback<T>{
        fun onSuccess(data : T?)
        fun onFailure(throwable: Throwable)
    }
}