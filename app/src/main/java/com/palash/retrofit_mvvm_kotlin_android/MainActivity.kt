package com.palash.retrofit_mvvm_kotlin_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.palash.retrofit_mvvm_kotlin_android.api.ApiUtilities
import com.palash.retrofit_mvvm_kotlin_android.api.MyApi
import com.palash.retrofit_mvvm_kotlin_android.repository.MemesRepository
import com.palash.retrofit_mvvm_kotlin_android.viewmodel.MainViewModel
import com.palash.retrofit_mvvm_kotlin_android.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get api interface...............
        val myApi = ApiUtilities.getRetrofitInstance().create(MyApi::class.java)
        //call repository...................
        val memesRepository = MemesRepository(myApi)

        //set view model factory
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(memesRepository))[MainViewModel::class.java]

        //data access from view model.....
        mainViewModel.memesLiveDataViewModel.observe(this) {
            it.data.memes.iterator().forEach {meme ->
                Log.d("MYLogs", "${meme.name}")
            }
            //Log.d("MyResult", "${it.toString()}")
        }
    }
}