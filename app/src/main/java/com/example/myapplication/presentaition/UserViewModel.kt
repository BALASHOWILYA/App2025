package com.example.myapplication.presentaition

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    fun fetchUsers() {
        val result = getUsersUseCase
        _users.value= result

    }
}