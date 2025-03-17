package com.example.myapplication.presentaition.viewmodelfactories.userfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.userusecase.GetUsersUseCase
import com.example.myapplication.presentaition.viewmodels.userviewmodel.UserViewModel

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(private val getUsersUseCase: GetUsersUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(getUsersUseCase) as T
    }

}