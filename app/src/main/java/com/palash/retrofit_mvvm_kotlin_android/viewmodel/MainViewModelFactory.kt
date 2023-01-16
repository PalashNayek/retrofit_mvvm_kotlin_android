package com.palash.retrofit_mvvm_kotlin_android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.palash.retrofit_mvvm_kotlin_android.repository.MemesRepository

class MainViewModelFactory(private val memesRepository: MemesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(memesRepository) as T
    }
}