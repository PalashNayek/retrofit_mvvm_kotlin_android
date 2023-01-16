package com.palash.retrofit_mvvm_kotlin_android.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.palash.retrofit_mvvm_kotlin_android.api.MyApi
import com.palash.retrofit_mvvm_kotlin_android.model.Jokes

class MemesRepository(private val myApi: MyApi) {
    //mutable livedata...............
    private val memesMutableLiveData = MutableLiveData<Jokes>()
    //livedata..............
    val memesLiveDataRepository : LiveData<Jokes> get() = memesMutableLiveData

    //This function get response ..............
    suspend fun getMemesRepository(){
        val responseResult = myApi.getMemes()
        if (responseResult.body()!=null){
            memesMutableLiveData.postValue(responseResult.body())
        }
    }
}