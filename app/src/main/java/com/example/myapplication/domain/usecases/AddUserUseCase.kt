package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.addUserRepository
import com.example.myapplication.domain.repositories.getUsersRepository

class AddUserUseCase(private val addUserRepository: addUserRepository) {

    suspend operator fun invoke(user: User){
        addUserRepository.addUser(user)
    }
}