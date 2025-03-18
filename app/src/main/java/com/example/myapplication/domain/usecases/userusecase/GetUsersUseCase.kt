package com.example.myapplication.domain.usecases.userusecase

import com.example.myapplication.domain.repositories.userrepository.IGetUsersRepository
import com.example.myapplication.domain.models.User

class GetUsersUseCase(private val getUsersRepository: IGetUsersRepository){

       suspend operator fun invoke(): List<User>{
        return  getUsersRepository.getUsers()
    }

}