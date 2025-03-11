package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.userrepository.AddUserRepository

class AddUserUseCase(private val addUserRepository: AddUserRepository) {

    suspend operator fun invoke(user: User){
        addUserRepository.addUser(user)
    }
}