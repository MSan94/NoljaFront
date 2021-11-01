package com.prj.nolja.data.model

import com.google.gson.annotations.SerializedName

/**
 * 유저 엔티티
 */
data class UserModel(
    @field:SerializedName("uno")
    val uno: Long? = null,
    @field:SerializedName("userName")
    val userName: String? = null,
    @field:SerializedName("userPassworld")
    val userPassword: String? = null,
    @field:SerializedName("userNick")
    val userNick: String? = null,
    @field:SerializedName("userEmail")
    val userEmail: String? = null
)