package com.example.myapplication.domain.usecases.userusecase

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.IGetLastUserRepository


class GetUserUseCase(private val getLastUserRepository: IGetLastUserRepository ) {

    suspend operator fun invoke(): User? {
        return getLastUserRepository.getUser()

    }
}