package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.repositories.getUsersRepository
import com.example.myapplication.domain.models.User

class GetUsersUseCase(private val getUsersRepository: getUsersRepository){

       suspend operator fun invoke(): List<User>{
        return  getUsersRepository.getUsers()
    }

}