package com.example.myapplication.presentaition.viewmodels.userviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import kotlinx.coroutines.launch

class AddUserViewModel(private val addUserUseCase: AddUserUseCase) : ViewModel() {

    fun addUser(user: User) = viewModelScope.launch {
        addUserUseCase(user = user)

    }
}