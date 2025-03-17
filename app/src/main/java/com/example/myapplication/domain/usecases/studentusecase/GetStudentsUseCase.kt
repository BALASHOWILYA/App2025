package com.example.myapplication.domain.usecases.studentusecase

import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.studentrepository.GetStudentsRepository
import com.example.myapplication.domain.repositories.userrepository.GetUsersRepository

class GetStudentsUseCase(private val getStudentsRepository: GetStudentsRepository) {

    suspend operator fun invoke(): List<Student>{
        return  getStudentsRepository.getStudents()
    }
}