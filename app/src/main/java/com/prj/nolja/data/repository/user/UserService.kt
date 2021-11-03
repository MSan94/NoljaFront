package com.prj.nolja.data.repository.user

import com.prj.nolja.data.model.CommonModel
import com.prj.nolja.data.model.User
import com.prj.nolja.data.model.UserModel
import retrofit2.Call
import retrofit2.http.*

/**
 * 유저 관련 레트로핏 서비스
 */
interface UserService {
    /** 로그인 **/
    @FormUrlEncoded
    @POST("/select/user")
    fun selectUser(@Field("id") id: String, @Field("pw") pw: String): Call<User>

    /** 아이디 중복 체크 **/
    @FormUrlEncoded
    @POST("/select/id")
    fun validUserId(@Field("id") id: String): Call<CommonModel>

    /** 회원가입 **/
    @FormUrlEncoded
    @POST("/insert/user")
    fun insertUser(
        @Field("id") id: String,
        @Field("pw") pw: String,
        @Field("email") email: String,
        @Field("nick") inick: String
    ): Call<CommonModel>

    /** 메일 전송 **/
    @FormUrlEncoded
    @POST("/requestMail")
    fun requestMail(
        @Field("receiverMail") receiverMail : String
    ): Call<CommonModel>
}