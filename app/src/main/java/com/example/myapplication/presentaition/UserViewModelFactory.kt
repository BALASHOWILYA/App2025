package com.example.myapplication.presentaition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.GetUsersUseCase

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(private val getUsersUseCase: GetUsersUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(getUsersUseCase) as T
    }

}