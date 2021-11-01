package com.prj.nolja.data.repository.user

import com.prj.nolja.data.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 유저 관련 레트로핏 서비스
 */
interface UserService {
    @GET("/")
    fun getMyInfo(@Query("ServiceKey") user : UserModel) : Call<UserModel>
}