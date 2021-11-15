package com.prj.nolja.data.repository.board

import com.prj.nolja.data.model.BoardModel
import com.prj.nolja.data.model.BoardModelList
import com.prj.nolja.data.model.CommonModel
import com.prj.nolja.data.model.User

object BoardRepository {
    private val retrofitDataSource = BoardRemoteDataSource

    /**
     * 글 등록
     */
    fun insertBoard(writer:String, subject:String, gender:String, imgfile:String, callback:getDataCallback<BoardModel>){
        retrofitDataSource.insertBoard(writer, subject, gender, imgfile, callback)
    }

    fun selectBoard(callback:getDataCallback<BoardModelList>){
        retrofitDataSource.selectBoard(callback)
    }

    /**
     * 데이터 콜백
     */
    interface getDataCallback<T>{
        fun onSuccess(data : T?)
        fun onFailure(throwable: Throwable)
    }
}