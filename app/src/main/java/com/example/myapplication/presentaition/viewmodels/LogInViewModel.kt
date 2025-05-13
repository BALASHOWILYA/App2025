package com.example.myapplication.presentaition.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.states.UserLoginState
import com.example.myapplication.domain.usecases.authenticationusecase.InterUserAccountUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class LogInViewModel(private val interUserAccountUseCase: InterUserAccountUseCase): ViewModel() {

    private var _stateLogin by mutableStateOf(UserLoginState())

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _users = MutableStateFlow<com.example.myapplication.domain.models.User>(User())
    val users: StateFlow<com.example.myapplication.domain.models.User> = _users

    fun onPhoneNumberChange(phoneNumber: String){
        _stateLogin = _stateLogin.copy(phoneNumber = phoneNumber)
    }

    fun onPasswordChange(password: String){
        _stateLogin = _stateLogin.copy(password = password)
    }

    private fun checkUserLogin(userLoginState: UserLoginState) = viewModelScope.launch {
        if(_stateLogin.phoneNumber != "" && _stateLogin.password != ""){
            val user = interUserAccountUseCase.invoke(UserLoginState(_stateLogin.phoneNumber, _stateLogin.password))
            if( user != null){
                _users.value= user
            }
        }

    }

    init{
        checkUserLogin(_stateLogin)
    }

    class LoginState



}

