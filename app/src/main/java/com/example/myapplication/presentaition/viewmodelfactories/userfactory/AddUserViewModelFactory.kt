package com.example.myapplication.presentaition.viewmodelfactories.userfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel

@Suppress("UNCHECKED_CAST")
class AddUserViewModelFactory(private val addUserUseCase: AddUserUseCase): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddUserViewModel(addUserUseCase) as T
    }
}