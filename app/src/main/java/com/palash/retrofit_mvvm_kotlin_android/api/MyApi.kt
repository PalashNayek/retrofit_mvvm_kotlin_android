package com.palash.retrofit_mvvm_kotlin_android.api

import com.palash.retrofit_mvvm_kotlin_android.model.Jokes
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("/get_memes")
    suspend fun getMemes() : Response<Jokes>
}