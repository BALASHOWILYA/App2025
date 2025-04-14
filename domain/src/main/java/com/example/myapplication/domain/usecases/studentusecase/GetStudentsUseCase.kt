package com.example.myapplication.domain.usecases.studentusecase

import com.example.myapplication.domain.models.Student
import com.example.myapplication.domain.repositories.studentrepository.IGetStudentsRepository

class GetStudentsUseCase(private val getStudentsRepository: com.example.myapplication.domain.repositories.studentrepository.IGetStudentsRepository) {

    suspend operator fun invoke(): List<com.example.myapplication.domain.models.Student>{
        return  getStudentsRepository.getStudents()
    }
}