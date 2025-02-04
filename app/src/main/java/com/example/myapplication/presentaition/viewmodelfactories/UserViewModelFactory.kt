package com.example.myapplication.presentaition.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myapplication.domain.usecases.GetUsersUseCase
import com.example.myapplication.presentaition.viewmodels.UserViewModel

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(private val getUsersUseCase: GetUsersUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(getUsersUseCase) as T
    }

}