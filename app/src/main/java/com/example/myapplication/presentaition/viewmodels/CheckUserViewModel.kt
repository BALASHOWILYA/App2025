package com.example.myapplication.presentaition.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.states.UserLoginState
import com.example.myapplication.domain.usecases.authenticationusecase.InterUserAccountUseCase
import com.example.myapplication.domain.usecases.userusecase.CheckUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CheckUserViewModel(private val checkUserUseCase: CheckUserUseCase?): ViewModel() {


    fun checkUser(user: com.example.myapplication.domain.models.User) = viewModelScope.launch {
         checkUserUseCase?.let { it(user = user) }

    }



}

