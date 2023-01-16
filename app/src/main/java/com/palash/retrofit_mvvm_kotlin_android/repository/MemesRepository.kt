package com.palash.retrofit_mvvm_kotlin_android.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.palash.retrofit_mvvm_kotlin_android.api.MyApi
import com.palash.retrofit_mvvm_kotlin_android.model.Jokes

class MemesRepository(val myApi: MyApi) {
    private val memesMutableLiveData = MutableLiveData<Jokes>()
    val memesLiveDataRepository : LiveData<Jokes> get() = memesMutableLiveData

    suspend fun getMemesRepository(){
        val responseResult = myApi.getMemes()
        if (responseResult.body()!=null){
            memesMutableLiveData.postValue(responseResult.body())
        }
    }
}