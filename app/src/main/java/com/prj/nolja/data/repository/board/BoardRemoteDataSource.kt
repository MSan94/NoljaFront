package com.prj.nolja.data.repository.board

import com.prj.nolja.data.model.BoardModel
import com.prj.nolja.data.model.BoardModelList
import com.prj.nolja.data.model.CommonModel
import com.prj.nolja.data.model.User
import com.prj.nolja.data.repository.retrofit.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object BoardRemoteDataSource {
    private val retrofit = RetrofitObject.retrofitService
    val boardApiService: BoardService = retrofit.create(BoardService::class.java)

    /** 이메일 등록 **/
    fun insertBoard(writer:String, subject:String, gender:String, imgfile:String, callback: BoardRepository.getDataCallback<BoardModel>){
        boardApiService.insertBoard(writer, subject, gender, imgfile).enqueue(object : Callback<BoardModel>{
            override fun onResponse(call: Call<BoardModel>, response: Response<BoardModel>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                }
            }
            override fun onFailure(call: Call<BoardModel>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    fun selectBoard(callback: BoardRepository.getDataCallback<BoardModelList>){
        boardApiService.selectBoard().enqueue(object : Callback<BoardModelList>{
            override fun onResponse(call: Call<BoardModelList>, response: Response<BoardModelList>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<BoardModelList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}