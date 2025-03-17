package com.example.myapplication.presentaition.viewmodels.userviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.userusecase.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UserViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() = viewModelScope.launch {

        val result = getUsersUseCase()
        _users.value= result
    }

}