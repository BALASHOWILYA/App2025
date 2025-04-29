package com.example.myapplication.presentaition.viewmodels.userviewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.userusecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GetUserViewModel(private val getUserUseCase: GetUserUseCase)  : ViewModel(){

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    init {
        fetchUser()
    }

    private fun fetchUser() = viewModelScope.launch {

            val lastUser = getUserUseCase()
            _user.value = lastUser
    }
}
