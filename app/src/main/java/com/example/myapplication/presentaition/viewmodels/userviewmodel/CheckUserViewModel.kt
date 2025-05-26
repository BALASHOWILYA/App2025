package com.example.myapplication.presentaition.viewmodels.userviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecases.userusecase.CheckUserUseCase
import kotlinx.coroutines.launch


class CheckUserViewModel(private val checkUserUseCase: CheckUserUseCase): ViewModel() {


    fun checkUser(user: com.example.myapplication.domain.models.User) = viewModelScope.launch {
        checkUserUseCase(user = user)

    }



}

