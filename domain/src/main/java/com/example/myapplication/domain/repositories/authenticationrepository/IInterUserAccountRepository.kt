package com.example.myapplication.domain.repositories.authenticationrepository

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.states.UserLoginState

interface IInterUserAccountRepository {

    suspend fun interUserAccount(userLoginState: UserLoginState): User?

}