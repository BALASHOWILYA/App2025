package com.example.myapplication.presentaition.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.AddUserUseCase
import com.example.myapplication.domain.usecases.GetUsersUseCase
import kotlinx.coroutines.launch

class AddUserViewModel(private val addUserUseCase: AddUserUseCase) : ViewModel() {

    fun addUser(user: User) = viewModelScope.launch {
        addUserUseCase(user = user)
    }
}