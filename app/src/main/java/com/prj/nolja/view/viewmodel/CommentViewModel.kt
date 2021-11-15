package com.prj.nolja.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.prj.nolja.data.model.BoardModel
import com.prj.nolja.data.model.BoardModelList
import com.prj.nolja.data.repository.board.BoardRepository

class CommentViewMode(application:Application) : AndroidViewModel(application) {

    val _allComment : LiveData<List<BoardModel>> = BoardRepository.selectBoard(object : BoardRepository.getDataCallback<BoardModelList>{

    })

}