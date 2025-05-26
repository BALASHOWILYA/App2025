package com.example.myapplication.domain.usecases.userusecase

import com.example.myapplication.domain.models.User

class CheckUserUseCase(private val checkUserRepository: com.example.myapplication.domain.repositories.userrepository.ICheckUserRepository)  {
    suspend operator fun invoke(user: com.example.myapplication.domain.models.User): User? {

        val mUser = checkUserRepository.checkUser(user)
        return mUser
    }
}