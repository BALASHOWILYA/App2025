package com.example.myapplication.domain.usecases.userusecase

import com.example.myapplication.domain.repositories.userrepository.GetUsersRepository
import com.example.myapplication.domain.models.User

class GetUsersUseCase(private val getUsersRepository: GetUsersRepository){

       suspend operator fun invoke(): List<User>{
        return  getUsersRepository.getUsers()
    }

}