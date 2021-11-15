package com.prj.nolja.data.model

import com.google.gson.annotations.SerializedName

class BoardModelList (
    @SerializedName("boardList")
    val boardList : List<BoardModel>
)