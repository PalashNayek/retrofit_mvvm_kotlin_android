package com.palash.retrofit_mvvm_kotlin_android.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {
    val BASE_URL="https://api.imgflip.com/"

    //This function return retrofit instance
    fun getRetrofitInstance() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}