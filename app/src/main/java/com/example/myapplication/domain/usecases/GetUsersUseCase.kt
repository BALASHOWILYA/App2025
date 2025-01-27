package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.repositories.UserRepository
import com.example.myapplication.domain.models.User

class GetUsersUseCase(private val userRepository: UserRepository){

       suspend operator fun invoke(): List<User>{
        return  userRepository.getUsers()
    }

}