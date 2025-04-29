package com.example.myapplication.domain.usecases.userusecase

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.IGetUserRepository

class GetUserUseCase(private val getUserRepository: IGetUserRepository ) {

    suspend operator fun invoke(): User {
        return getUserRepository.getUser()

    }
}