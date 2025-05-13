package com.example.myapplication.domain.usecases.authenticationusecase

import com.example.myapplication.domain.repositories.authenticationrepository.IInterUserAccountRepository
import com.example.myapplication.domain.states.UserLoginState

class InterUserAccountUseCase(private val interUserAccountRepository: IInterUserAccountRepository)  {

    suspend operator fun invoke(userLoginState: UserLoginState){
        interUserAccountRepository.interUserAccount(userLoginState)
    }
}