package com.prj.nolja.data.repository.board

import com.prj.nolja.data.model.*
import retrofit2.Call
import retrofit2.http.*

/**
 * 유저 관련 레트로핏 서비스
 */
interface BoardService {
    /** 로그인 **/
    @FormUrlEncoded
    @POST("/insert/board")
    fun insertBoard(@Field("writer") writer: String, @Field("subject") subject: String, @Field("gender") gender:String, @Field("imgfile") imgfile : String): Call<BoardModel>

    @FormUrlEncoded
    @POST("select/board")
    fun selectBoard() : Call<BoardModelList>
}