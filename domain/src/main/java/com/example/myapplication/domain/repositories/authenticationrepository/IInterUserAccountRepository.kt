package com.example.myapplication.domain.repositories.authenticationrepository

import com.example.myapplication.domain.states.UserLoginState

interface IInterUserAccountRepository {

    fun interUserAccount(userLoginState: UserLoginState)

}