package com.prj.nolja.data.repository.user

import android.util.Log
import com.prj.nolja.data.model.User
import com.prj.nolja.data.model.UserModel
import com.prj.nolja.data.repository.retrofit.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRemoteDataSource {
    private val retrofit = RetrofitObject.retrofitService
    val userApiService : UserService = retrofit.create(UserService::class.java)

    fun selectUser(id:String, pw:String, callback : UserRepository.getDataCallback<User>) {
        userApiService.selectUser(id, pw).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }
}