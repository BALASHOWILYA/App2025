package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.repositories.GetUsersRepository
import com.example.myapplication.domain.models.User

class GetUsersUseCase(private val getUsersRepository: GetUsersRepository){

       suspend operator fun invoke(): List<User>{
        return  getUsersRepository.getUsers()
    }

}