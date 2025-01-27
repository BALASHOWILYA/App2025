package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.repositories.UserRepository
import com.example.myapplication.domain.models.User

class GetUsersUseCase(private val userRepository: UserRepository) : List<User> {

    fun execute(): List<User>{
        return  userRepository.getUsers()
    }

}