package com.prj.nolja.data.repository.retrofit

import com.prj.nolja.BuildConfig
import com.prj.nolja.data.repository.user.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 레트로핏 오브젝트
 */
object RetrofitObject {
    private val baseUrl = ""

    private fun createOkHttpClient() : OkHttpClient{
        val interceptor = HttpLoggingInterceptor()

        if(BuildConfig.DEBUG){
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }else{
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    val retrofitService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()

}