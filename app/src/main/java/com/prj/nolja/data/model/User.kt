package com.prj.nolja.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @field:SerializedName("result")
    val result: String? = null,
    @field:SerializedName("data")
    val data: UserModel? = null
)
