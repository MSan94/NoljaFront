package com.prj.nolja.data.model

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

class BoardModel {

    @field:SerializedName("id")
    val id : String? = null
    @field:SerializedName("subject")
    val subject: String? = null
    @field:SerializedName("type")
    val type: String? = null
    @field:SerializedName("imgfile")
    val imgfile: MultipartBody.Part? = null
}