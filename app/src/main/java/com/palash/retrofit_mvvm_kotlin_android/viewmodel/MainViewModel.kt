package com.palash.retrofit_mvvm_kotlin_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palash.retrofit_mvvm_kotlin_android.model.Jokes
import com.palash.retrofit_mvvm_kotlin_android.repository.MemesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val memesRepository: MemesRepository) : ViewModel(){
    init {
        viewModelScope.launch(Dispatchers.IO) {
            memesRepository.getMemesRepository()
        }
    }

    val memesLiveDataViewModel : LiveData<Jokes> get() = memesRepository.memesLiveDataRepository
}