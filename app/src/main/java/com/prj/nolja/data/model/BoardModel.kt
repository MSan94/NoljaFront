package com.prj.nolja.data.model

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

class BoardModel {
    @field:SerializedName("bno")
    val bno : Int = 0
    @field:SerializedName("writer")
    val writer : String? = null
    @field:SerializedName("subject")
    val subject: String? = null
    @field:SerializedName("gender")
    val gender: String? = null
    @field:SerializedName("imgfile")
    val imgfile : MultipartBody.Part? = null
    @field:SerializedName("useAt")
    val useAt : String = "Y"
    @field:SerializedName("result")
    val result : String? = null
}