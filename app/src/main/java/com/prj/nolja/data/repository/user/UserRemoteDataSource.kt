package com.prj.nolja.data.repository.user

import com.prj.nolja.data.model.UserModel
import com.prj.nolja.data.repository.retrofit.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRemoteDataSource {
    private val retrofit = RetrofitObject.retrofitService
    val userApiService : UserService = retrofit.create(UserService::class.java)

    fun getMyInfo(userName : String , userPassword: String, callback : UserRepository.getDataCallback<UserModel>) {
        userApiService.getMyInfo(UserModel()).enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                }
            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }
}