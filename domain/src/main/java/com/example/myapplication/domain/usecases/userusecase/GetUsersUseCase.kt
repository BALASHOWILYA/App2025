package com.example.myapplication.domain.usecases.userusecase

import com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository
import com.example.myapplication.domain.models.User

class GetUsersUseCase(private val getUsersRepository: com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository){

       suspend operator fun invoke(): List<com.example.myapplication.domain.models.User>{
        return  getUsersRepository.getUsers()
    }

}