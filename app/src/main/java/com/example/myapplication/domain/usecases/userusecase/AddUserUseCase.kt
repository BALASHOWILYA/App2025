package com.example.myapplication.domain.usecases.userusecase

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.IAddUserRepository

class AddUserUseCase(private val addUserRepository: IAddUserRepository) {

    suspend operator fun invoke(user: User){
        addUserRepository.addUser(user)
    }
}